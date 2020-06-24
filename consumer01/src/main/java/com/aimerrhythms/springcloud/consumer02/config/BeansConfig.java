package com.aimerrhythms.springcloud.consumer02.config;

import com.aimerrhythms.springcloud.consumer02.interceptor.MyRestInterceptor;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new MyRestInterceptor());
        return restTemplate;
    }

//    @Bean
    public IRule createRule() {
        //轮询
//        return new RoundRobinRule();
        //随机
        return new RandomRule();
        //重试
//        return new RetryRule();
    }
}
