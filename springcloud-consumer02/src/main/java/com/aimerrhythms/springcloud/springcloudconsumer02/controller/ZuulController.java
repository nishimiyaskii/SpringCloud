package com.aimerrhythms.springcloud.springcloudconsumer02.controller;

import com.aimerrhythms.springcloud.springcloudconsumer02.service.ZuulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/8 23:07
 */
@RestController
public class ZuulController {

    @Autowired
    ZuulService zuulService;

    @Value("${server.port}")
    String port;

    @GetMapping("/alive")
    public String alive() {
        return "consumer port = " + port + " ---> " + zuulService.alive();
    }

}
