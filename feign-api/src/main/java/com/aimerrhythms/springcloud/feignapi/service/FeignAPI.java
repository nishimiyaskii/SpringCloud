package com.aimerrhythms.springcloud.feignapi.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aimerrhythms
 * @data 2020/6/5 22:49
 */
@RequestMapping("/feign")
public interface FeignAPI {

    @GetMapping("/alive") //需要，要不然拦截不到方法（这个是给FeignService的OpenService看的）
    String alive();

    @GetMapping("/getId")
    String getId(@RequestParam("id") Integer id);

}
