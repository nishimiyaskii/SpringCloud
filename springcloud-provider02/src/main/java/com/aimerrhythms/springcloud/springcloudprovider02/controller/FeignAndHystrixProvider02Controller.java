package com.aimerrhythms.springcloud.springcloudprovider02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/7 19:59
 */
@RestController
public class FeignAndHystrixProvider02Controller {

    @Value("${server.port}")
    String port;

    @GetMapping("/alive")
    public String alive() {
        return "provider port = " + port;
    }

}
