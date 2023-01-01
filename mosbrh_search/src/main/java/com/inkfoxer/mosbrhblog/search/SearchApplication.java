package com.inkfoxer.mosbrhblog.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 灵雨
 * @date 2020年1月10日21:08:23
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class})
@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients("com.inkfoxer.mosbrhblog.commons.feign")
@ComponentScan(basePackages = {
        "com.inkfoxer.mosbrhblog.commons.config.feign",
        "com.inkfoxer.mosbrhblog.commons.handler",
//        "com.inkfoxer.mosbrhblog.utils",
        "com.inkfoxer.mosbrhblog.search"
})
public class SearchApplication {
    public static void main(String[] args) {
        /**
         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决netty冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(SearchApplication.class, args);
    }
}
