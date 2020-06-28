package com.aimerrhythms.springcloud.consumer02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/28 21:27
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    @Value("${server.ports}")
    private String port;

    @GetMapping("/test")
    public String test() {
        return port;
    }
}
