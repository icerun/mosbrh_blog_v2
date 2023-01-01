package com.inkfoxer.mosbrhblog.picture.config;

import com.inkfoxer.mosbrhblog.base.handler.HandlerExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局异常处理配置
 *
 * @author 灵雨
 * @date 2020年10月4日10:44:17
 */
@Configuration
public class GlobalExceptionConfig {

    @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver() {
        return new HandlerExceptionResolver();
    }
}
