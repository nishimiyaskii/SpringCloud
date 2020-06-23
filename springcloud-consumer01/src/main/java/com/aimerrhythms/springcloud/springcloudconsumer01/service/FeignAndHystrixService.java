package com.aimerrhythms.springcloud.springcloudconsumer01.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @FeignClient： fallback属性，可指定fallback类
 *                fallbackfactory属性，可指定fallbackfactory类
 * @author aimerrhythms
 * @data 2020/6/7 19:53
 */
//@FeignClient(name = "springcloud-provider", fallbackFactory = FeignAndHystrixFallBackFactory.class)
@FeignClient(name = "springcloud-provider")
public interface FeignAndHystrixService {

    @GetMapping("/alive")
    String alive();

}
