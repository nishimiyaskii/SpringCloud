package com.aimerrhythms.springcloud.feignprovider2.controller;

import com.aimerrhythms.springcloud.feignapi.service.FeignAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aimerrhythms
 * @data 2020/6/6 23:14
 */
@RestController
public class FeignProviderController2 implements FeignAPI {

    @Value("${server.port}")
    String port;

    @Override
    public String alive() {
        return "port = " + port;
    }

    @Override
    public String getId(Integer id) {
        return null;
    }
}
