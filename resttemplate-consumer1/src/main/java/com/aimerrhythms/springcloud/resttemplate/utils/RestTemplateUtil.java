package com.aimerrhythms.springcloud.resttemplate.utils;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author aimerrhythms
 * @data 2020/6/5 20:46
 */
@Configuration
public class RestTemplateUtil {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
