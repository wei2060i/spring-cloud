package com.nacos.web_user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 开启feign详细日志
 * logging:
 *   level:
 *     com.nacos.web_user.feign: debug
 */
//@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
