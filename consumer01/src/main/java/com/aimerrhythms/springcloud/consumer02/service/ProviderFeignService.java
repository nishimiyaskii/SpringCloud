package com.aimerrhythms.springcloud.consumer02.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import to.PersonTo;

/**
 * @author aimerrhythms
 * @data 2020/6/25 23:22
 */
@FeignClient("provider")
public interface ProviderFeignService {

    @GetMapping("/feignTest")
    String feignTest();

    @GetMapping("/getById")
    String getById(@RequestParam("id") Integer id);

    @PostMapping("/save")
    PersonTo save(@RequestBody PersonTo to);

    @GetMapping("/retry")
    String retry();

}
