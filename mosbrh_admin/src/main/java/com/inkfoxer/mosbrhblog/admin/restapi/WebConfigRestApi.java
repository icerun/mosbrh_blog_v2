package com.inkfoxer.mosbrhblog.admin.restapi;


import com.inkfoxer.mosbrhblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.inkfoxer.mosbrhblog.admin.annotion.OperationLogger.OperationLogger;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.xo.service.WebConfigService;
import com.inkfoxer.mosbrhblog.xo.vo.WebConfigVO;
import com.inkfoxer.mosbrhblog.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 网站配置表 RestApi
 *
 * @author 灵雨
 * @date 2018年11月11日15:19:28
 */
@Api(value = "网站配置相关接口", tags = {"网站配置相关接口"})
@RestController
@RequestMapping("/webConfig")
@Slf4j
public class WebConfigRestApi {

    @Autowired
    WebConfigService webConfigService;

    @AuthorityVerify
    @ApiOperation(value = "获取网站配置", notes = "获取网站配置")
    @GetMapping("/getWebConfig")
    public String getWebConfig() {
        return ResultUtil.successWithData(webConfigService.getWebConfig());
    }

    @AuthorityVerify
    @OperationLogger(value = "修改网站配置")
    @ApiOperation(value = "修改网站配置", notes = "修改网站配置")
    @PostMapping("/editWebConfig")
    public String editWebConfig(@Validated({Update.class}) @RequestBody WebConfigVO webConfigVO, BindingResult result) {
        return webConfigService.editWebConfig(webConfigVO);
    }
}
