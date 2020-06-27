package com.aimerrhythms.springcloud.consumer02.controller;

import com.aimerrhythms.springcloud.consumer02.service.HystrixAndFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author aimerrhythms
 * @data 2020/6/26 23:29
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController01 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixAndFeignService hystrixAndFeignService;

    @GetMapping("/test")
    @HystrixCommand(fallbackMethod = "back")
    public String test() {
        String url = "http://provider/hystrixTest";
        int i = 1 / 0;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/hfTest")
    public String hfTest() {
        return hystrixAndFeignService.hfTest();
    }

    public String back() {
        System.out.println("执行了fallback方法");
        return "出现异常了";
    }

}
