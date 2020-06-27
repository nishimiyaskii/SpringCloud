package com.aimerrhythms.springcloud.consumer02.service;

import com.aimerrhythms.springcloud.consumer02.exception.HystrixAndFeignFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author aimerrhythms
 * @data 2020/6/26 23:43
 */
//fallback 是当接口中的方法抛出异常的时候，执行哪个类中的同名方法
//@FeignClient(name = "provider", fallback = HystrixAndFeignFallBack.class)
@FeignClient(name = "provider", fallbackFactory = HystrixAndFeignFallBackFactory.class)
public interface HystrixAndFeignService {

    @GetMapping("/hfTest")
    String hfTest();

}
