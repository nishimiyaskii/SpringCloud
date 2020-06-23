package com.aimerrhythms.springcloud.springcloudconsumer01.controller;

import com.aimerrhythms.springcloud.springcloudconsumer01.service.FeignAndHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aimerrhythms
 * @data 2020/6/7 19:51
 */
@RestController
public class FeignAndHystrixConsumer01Controller {

    @Autowired
    FeignAndHystrixService feignAndHystrixService;

    @Value("${server.port}")
    String port;


    @GetMapping("/alive")
    public String alive() {
        return "consumer port = " + port + " ---> " + feignAndHystrixService.alive();
    }

}
