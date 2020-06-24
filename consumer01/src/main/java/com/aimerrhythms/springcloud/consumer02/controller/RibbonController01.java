package com.aimerrhythms.springcloud.consumer02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author aimerrhythms
 * @data 2020/6/24 21:50
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController01 {

    @Autowired
    private LoadBalancerClient lb;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/test")
    public String ribbon() {
        ServiceInstance provider = lb.choose("provider");
        String host = provider.getHost();
        int port = provider.getPort();
        String url = "http://" + host + ":" + port + "/ribbonTest";
        System.out.println("url = " + url);
        return new RestTemplate().getForObject(url, String.class);
    }

}
