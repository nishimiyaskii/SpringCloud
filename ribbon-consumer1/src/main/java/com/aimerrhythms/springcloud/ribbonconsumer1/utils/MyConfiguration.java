package com.aimerrhythms.springcloud.ribbonconsumer1.utils;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author aimerrhythms
 * @data 2020/6/4 23:04
 */
@Configuration
public class MyConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 使用Ribbon提供的其他负载均衡策略
     * @return
     */
//    @Bean
    public IRule myRule() {
        //轮询
        return new RoundRobinRule();
        //重试
//        return new RetryRule();
        //随机
//        return new RandomRule();
    }

}
