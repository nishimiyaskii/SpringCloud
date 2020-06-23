package com.aimerrhythms.springcloud.consumer02.controller;

import com.aimerrhythms.springcloud.consumer02.service.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/22 23:08
 */
@RestController
public class ConsumerController01 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private HealthStatusService healthStatusService;

    @GetMapping("/discoveryClient")
    public Map<String, Object> discoveryClientTest() {
        Map<String, Object> map = new HashMap<>();
        /*
            org.springframework.cloud.client.discovery.DiscoveryClient
        */
        String description = discoveryClient.description();
        List<ServiceInstance> consumers = discoveryClient.getInstances("consumer");
        List<String> services = discoveryClient.getServices();
        map.put("description", description);
        map.put("consumers", consumers);
        map.put("services", services);

        /* com.netflix.discovery.DiscoveryClient */
        return map;
    }

    @GetMapping("/ESHealthCheck")
    public String ESHealthCheckTest(@RequestParam("status") Boolean status) {
        healthStatusService.setStatus(status);
        //调用health方法，根据status状态决定是否下线服务
        Health health = healthStatusService.health();
        return healthStatusService.getStatus() + "";
    }


}
