package com.inkfoxer.mosbrhblog.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inkfoxer.mosbrhblog.commons.entity.Admin;
import com.inkfoxer.mosbrhblog.commons.entity.Role;
import com.inkfoxer.mosbrhblog.utils.RedisUtil;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.utils.StringUtils;
import com.inkfoxer.mosbrhblog.xo.global.MessageConf;
import com.inkfoxer.mosbrhblog.xo.global.RedisConf;
import com.inkfoxer.mosbrhblog.xo.global.SQLConf;
import com.inkfoxer.mosbrhblog.xo.global.SysConf;
import com.inkfoxer.mosbrhblog.xo.mapper.RoleMapper;
import com.inkfoxer.mosbrhblog.xo.service.AdminService;
import com.inkfoxer.mosbrhblog.xo.service.RoleService;
import com.inkfoxer.mosbrhblog.xo.vo.RoleVO;
import com.inkfoxer.mosbrhblog.base.enums.EStatus;
import com.inkfoxer.mosbrhblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author limbo
 * @since 2018-09-30
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminService adminService;

    @Override
    public IPage<Role> getPageList(RoleVO roleVO) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(roleVO.getKeyword()) && StringUtils.isNotEmpty(roleVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.ROLENAEM, roleVO.getKeyword().trim());
        }
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        Page<Role> page = new Page<>();
        page.setCurrent(roleVO.getCurrentPage());
        page.setSize(roleVO.getPageSize());
        IPage<Role> pageList = roleService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public String addRole(RoleVO roleVO) {
        String roleName = roleVO.getRoleName();
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLENAEM, roleName);
        Role getRole = roleService.getOne(queryWrapper);
        if (getRole == null) {
            Role role = new Role();
            role.setRoleName(roleVO.getRoleName());
            role.setCategoryMenuUids(roleVO.getCategoryMenuUids());
            role.setSummary(roleVO.getSummary());
            role.insert();
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
        }
        return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
    }

    @Override
    public String editRole(RoleVO roleVO) {
        String uid = roleVO.getUid();
        Role getRole = roleService.getById(uid);
        if (getRole == null) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        getRole.setRoleName(roleVO.getRoleName());
        getRole.setCategoryMenuUids(roleVO.getCategoryMenuUids());
        getRole.setSummary(roleVO.getSummary());
        getRole.setUpdateTime(new Date());
        getRole.updateById();
        // 修改成功后，需要删除redis中所有的admin访问路径
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteRole(RoleVO roleVO) {
        // 判断该角色下是否绑定了管理员
        QueryWrapper<Admin> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        blogQueryWrapper.in(SQLConf.ROLEUID, roleVO.getUid());
        Integer adminCount = adminService.count(blogQueryWrapper);
        if (adminCount > 0) {
            return ResultUtil.errorWithMessage(MessageConf.ADMIN_UNDER_THIS_ROLE);
        }
        Role role = roleService.getById(roleVO.getUid());
        role.setStatus(EStatus.DISABLED);
        role.setUpdateTime(new Date());
        role.updateById();
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }


    /**
     * 删除Redis中管理员的访问路径
     */
    private void deleteAdminVisitUrl() {
        Set<String> keys = redisUtil.keys(RedisConf.ADMIN_VISIT_MENU + "*");
        redisUtil.delete(keys);
    }
}
