package com.inkfoxer.mosbrhblog.admin.restapi;


import com.inkfoxer.mosbrhblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.inkfoxer.mosbrhblog.admin.annotion.AvoidRepeatableCommit.AvoidRepeatableCommit;
import com.inkfoxer.mosbrhblog.admin.annotion.OperationLogger.OperationLogger;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.xo.service.SysDictTypeService;
import com.inkfoxer.mosbrhblog.xo.vo.SysDictTypeVO;
import com.inkfoxer.mosbrhblog.base.exception.ThrowableUtils;
import com.inkfoxer.mosbrhblog.base.validator.group.Delete;
import com.inkfoxer.mosbrhblog.base.validator.group.GetList;
import com.inkfoxer.mosbrhblog.base.validator.group.Insert;
import com.inkfoxer.mosbrhblog.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 字典类型 RestApi
 *
 * @author 灵雨
 * @date 2020年2月15日21:16:31
 */
@RestController
@RequestMapping("/sysDictType")
@Api(value = "字典类型相关接口", tags = {"字典类型相关接口"})
@Slf4j
public class SysDictTypeRestApi {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    @AuthorityVerify
    @ApiOperation(value = "获取字典类型列表", notes = "获取字典类型列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SysDictTypeVO sysDictTypeVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取字典类型列表");
        return ResultUtil.successWithData(sysDictTypeService.getPageList(sysDictTypeVO));
    }

    @AvoidRepeatableCommit
    @AuthorityVerify
    @OperationLogger(value = "增加字典类型")
    @ApiOperation(value = "增加字典类型", notes = "增加字典类型", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody SysDictTypeVO sysDictTypeVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.addSysDictType(sysDictTypeVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "编辑字典类型")
    @ApiOperation(value = "编辑字典类型", notes = "编辑字典类型", response = String.class)
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody SysDictTypeVO sysDictTypeVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.editSysDictType(sysDictTypeVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "批量删除字典类型")
    @ApiOperation(value = "批量删除字典类型", notes = "批量删除字典类型", response = String.class)
    @PostMapping("/deleteBatch")
    public String delete(HttpServletRequest request, @Validated({Delete.class}) @RequestBody List<SysDictTypeVO> sysDictTypeVoList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.deleteBatchSysDictType(sysDictTypeVoList);
    }
}

