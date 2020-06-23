package com.aimerrhythms.springcloud.feignconsumer1.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 优势：没有代码侵入，解耦。方便做异构系统
 *
 * 缺点：和之前的RestTemplate没有方便多少
 * @author aimerrhythms
 * @data 2020/6/5 22:30
 */
//结合eureka，使用服务名调用
@FeignClient(name = "feign-provider")
public interface UserService2 {

//    @GetMapping("/alive")
//    String alive();

}
