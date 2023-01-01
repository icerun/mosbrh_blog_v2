package com.inkfoxer.mosbrhblog.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inkfoxer.mosbrhblog.commons.entity.Role;
import com.inkfoxer.mosbrhblog.xo.vo.RoleVO;
import com.inkfoxer.mosbrhblog.base.service.SuperService;

/**
 * 角色表 服务类
 *
 * @author 灵雨
 * @date 2018-09-04
 */
public interface RoleService extends SuperService<Role> {

    /**
     * 获取角色列表
     *
     * @param roleVO
     * @return
     */
    public IPage<Role> getPageList(RoleVO roleVO);

    /**
     * 新增角色
     *
     * @param roleVO
     */
    public String addRole(RoleVO roleVO);

    /**
     * 编辑角色
     *
     * @param roleVO
     */
    public String editRole(RoleVO roleVO);

    /**
     * 删除角色
     *
     * @param roleVO
     */
    public String deleteRole(RoleVO roleVO);

}
