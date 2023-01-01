package com.inkfoxer.mosbrhblog.picture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients("com.inkfoxer.mosbrhblog.commons.feign")
@ComponentScan(basePackages = {
        "com.inkfoxer.mosbrhblog.commons.config.feign",
        "com.inkfoxer.mosbrhblog.commons.handler",
        "com.inkfoxer.mosbrhblog.commons.config.redis",
        "com.inkfoxer.mosbrhblog.utils",
        "com.inkfoxer.mosbrhblog.picture"})
public class PictureApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureApplication.class, args);
    }
}
