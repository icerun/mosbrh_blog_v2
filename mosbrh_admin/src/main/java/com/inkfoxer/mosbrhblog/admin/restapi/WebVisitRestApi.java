package com.inkfoxer.mosbrhblog.admin.restapi;


import com.inkfoxer.mosbrhblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.inkfoxer.mosbrhblog.admin.global.SysConf;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.xo.service.WebVisitService;
import com.inkfoxer.mosbrhblog.xo.vo.WebVisitVO;
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
 * 用户访问表 RestApi
 *
 * @author 灵雨
 * @date 2019年5月17日08:38:09
 */
@Api(value = "用户访问相关接口", tags = {"用户访问相关接口"})
@RestController
@RequestMapping("/webVisit")
@Slf4j
public class WebVisitRestApi {

    @Autowired
    private WebVisitService webVisitService;

    @AuthorityVerify
    @ApiOperation(value = "获取用户访问列表", notes = "获取用户访问列表")
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody WebVisitVO webVisitVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, webVisitService.getPageList(webVisitVO));
    }
}

