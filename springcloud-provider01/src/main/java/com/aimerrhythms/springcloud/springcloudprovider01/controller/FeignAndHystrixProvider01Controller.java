package com.aimerrhythms.springcloud.springcloudprovider01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/7 19:57
 */
@RestController
public class FeignAndHystrixProvider01Controller {

    @Value("${server.port}")
    String port;

    @GetMapping("/alive")
    public String alive() {

        //模拟服务提供方出现错误
//        int i = 1 / 0;

        return "provider port = " + port;
    }

}
