package com.aimerrhythms.springcloud.ribbonconsumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author aimerrhythms
 * @data 2020/6/4 23:03
 */
@RestController
public class MainController {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;


    /**
     * 使用默认的区域轮询负载均衡策略
     * @return
     */
    @GetMapping("/ribbon1")
    public String ribbon1() {

        //ribbon选择一个在线的服务
        ServiceInstance instance = lb.choose("provider");

        System.out.println(instance.getPort());

        //使用RestTemplate进行远程调用
        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/provider", String.class);
    }


    /**
     * 手动负载均衡
     * @return
     */
    @GetMapping("/ribbon2")
    public String ribbon2() {

        List<ServiceInstance> list = discoveryClient.getInstances("provider");

        Random random = new Random();

        int index = random.nextInt(list.size());

        ServiceInstance instance = list.get(index);

        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/provider", String.class);
    }


    /**
     * 使用RestTemplate整合Ribbon，自动负载均衡
     *
     * 在RestTemplate的get方法上加注解：@LoadBalanced
     *
     * @return
     */
    @GetMapping("/ribbon3")
    public String ribbon3() {
        String url = "http://provider/provider";
        return restTemplate.getForObject(url, String.class);
    }


}
