package com.aimerrhythms.springcloud.springcloudconsumer02.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author aimerrhythms
 * @data 2020/6/8 23:09
 */
@FeignClient(name = "springcloud-provider")
public interface ZuulService {

    @GetMapping("/alive")
    String alive();
}
