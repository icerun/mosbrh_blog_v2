package com.inkfoxer.mosbrhblog.admin.restapi;


import com.inkfoxer.mosbrhblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.inkfoxer.mosbrhblog.admin.global.SysConf;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.xo.service.ExceptionLogService;
import com.inkfoxer.mosbrhblog.xo.service.SysLogService;
import com.inkfoxer.mosbrhblog.xo.vo.ExceptionLogVO;
import com.inkfoxer.mosbrhblog.xo.vo.SysLogVO;
import com.inkfoxer.mosbrhblog.base.exception.ThrowableUtils;
import com.inkfoxer.mosbrhblog.base.validator.group.GetList;
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

/**
 * 日志记录表 RestApi
 *
 * @author 灵雨
 * @since 2018年9月24日15:45:18
 */
@RestController
@Api(value = "操作日志相关接口", tags = {"操作日志相关接口"})
@RequestMapping("/log")
@Slf4j
public class LogRestApi {

    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private ExceptionLogService exceptionLogService;

    @AuthorityVerify
    @ApiOperation(value = "获取操作日志列表", notes = "获取操作日志列表", response = String.class)
    @PostMapping(value = "/getLogList")
    public String getLogList(@Validated({GetList.class}) @RequestBody SysLogVO sysLogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, sysLogService.getPageList(sysLogVO));
    }

    @AuthorityVerify
    @ApiOperation(value = "获取系统异常列表", notes = "获取系统异常列表", response = String.class)
    @PostMapping(value = "/getExceptionList")
    public String getExceptionList(@Validated({GetList.class}) @RequestBody ExceptionLogVO exceptionLogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, exceptionLogService.getPageList(exceptionLogVO));
    }
}

