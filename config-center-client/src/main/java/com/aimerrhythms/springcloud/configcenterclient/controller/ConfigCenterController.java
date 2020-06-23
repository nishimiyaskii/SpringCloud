package com.aimerrhythms.springcloud.configcenterclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/10 20:30
 */
@RestController
public class ConfigCenterController {

    @Value("${config}")
    private String config;

    @GetMapping("/myconfig")
    public String getConfig() {
        return config;
    }

}
