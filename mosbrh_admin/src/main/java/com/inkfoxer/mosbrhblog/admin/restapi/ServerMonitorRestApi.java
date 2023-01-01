package com.inkfoxer.mosbrhblog.admin.restapi;

import com.inkfoxer.mosbrhblog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.inkfoxer.mosbrhblog.admin.global.SysConf;
import com.inkfoxer.mosbrhblog.utils.ResultUtil;
import com.inkfoxer.mosbrhblog.utils.ServerInfo.ServerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务监控RestApi（CPU、内存、核心）
 *
 * @author 灵雨
 * @date 2020年6月3日09:11:16
 */

@RestController
@RequestMapping("/monitor")
@Api(value = "服务监控相关接口", tags = {"系统设置相关接口"})
@Slf4j
public class ServerMonitorRestApi {

    @AuthorityVerify
    @ApiOperation(value = "获取服务信息", notes = "获取服务信息")
    @GetMapping("/getServerInfo")
    public String getInfo() {
        ServerInfo server = new ServerInfo();
        server.copyTo();
        return ResultUtil.result(SysConf.SUCCESS, server);
    }

}
