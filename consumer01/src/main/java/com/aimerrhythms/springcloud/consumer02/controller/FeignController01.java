package com.aimerrhythms.springcloud.consumer02.controller;

import com.aimerrhythms.springcloud.consumer02.service.ProviderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import to.PersonTo;

/**
 * @author aimerrhythms
 * @data 2020/6/25 23:11
 */
@RestController
@RequestMapping("/feign")
public class FeignController01 {

    @Autowired
    private ProviderFeignService providerFeignService;

    @GetMapping("/test")
    public String test() {
        return providerFeignService.feignTest();
    }

    @GetMapping("/getById")
    public String getById() {
        return providerFeignService.getById(1);
    }

    @GetMapping("/save")
    public PersonTo save() {
        PersonTo to = new PersonTo(23, "aimerrhythms", 1, "HN");
        return providerFeignService.save(to);
    }

    @GetMapping("/retry")
    public String retry() {
        return providerFeignService.retry();
    }

}
