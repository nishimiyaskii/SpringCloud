package com.aimerrhythms.springcloud.consumer02.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author aimerrhythms
 * @data 2020/6/23 23:07
 */
@Configuration
public class BeansConfig {

    @Bean
    @LoadBalanced   //开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
