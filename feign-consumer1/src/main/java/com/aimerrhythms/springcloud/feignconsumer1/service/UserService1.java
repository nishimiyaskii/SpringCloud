package com.aimerrhythms.springcloud.feignconsumer1.service;

/**
 * @author aimerrhythms
 * @data 2020/6/5 22:11
 */

import org.springframework.cloud.openfeign.FeignClient;

//不通过eureka，直接通过openfeign远程调用，指定服务的ip:port（使用赤裸裸的url）
//注意：name属性一定要给。这里的话可以随便写
@FeignClient(name = "ooxx", url = "http://localhost:9090")
public interface UserService1 {

    /**
     * OpenFeign的特点就是能够识别SpringMVC的注解
     * 然后会自动的把@GetMapping中的资源路径拼接到url后面
     * @return
     */
//    @GetMapping("/alive")
//    String alive();
//
//    @GetMapping("/register")
//    String register();

}
