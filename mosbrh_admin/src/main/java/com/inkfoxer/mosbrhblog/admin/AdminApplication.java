package com.inkfoxer.mosbrhblog.admin;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * mosbrh-admin 启动类
 *
 * @author 灵雨
 * @date 2020年12月31日21:26:04
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableCaching
@EnableRabbit
@EnableFeignClients("com.inkfoxer.mosbrhblog.commons.feign")
@ComponentScan(basePackages = {
        "com.inkfoxer.mosbrhblog.commons.config",
        "com.inkfoxer.mosbrhblog.commons.fallback",
        "com.inkfoxer.mosbrhblog.utils",
        "com.inkfoxer.mosbrhblog.admin",
        "com.inkfoxer.mosbrhblog.xo.utils",
        "com.inkfoxer.mosbrhblog.xo.service"
})
public class AdminApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(AdminApplication.class, args);
    }

    /**
     * 设置时区
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
