package com.inkfoxer.mosbrhblog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableAsync
@EnableFeignClients("com.inkfoxer.mosbrhblog.commons.feign")
@ComponentScan(basePackages = {
        "com.inkfoxer.mosbrhblog.commons.config",
        "com.inkfoxer.mosbrhblog.commons.fallback",
        "com.inkfoxer.mosbrhblog.utils",
        "com.inkfoxer.mosbrhblog.xo.utils",
        "com.inkfoxer.mosbrhblog.web",
        "com.inkfoxer.mosbrhblog.xo.service"})
public class WebApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(WebApplication.class, args);
    }

    /**
     * 设置时区
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
