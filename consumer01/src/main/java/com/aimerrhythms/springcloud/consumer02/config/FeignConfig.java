package com.aimerrhythms.springcloud.consumer02.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 重写日志等级
 * @author aimerrhythms
 * @data 2020/6/26 19:37
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.BASIC;
    }

}
