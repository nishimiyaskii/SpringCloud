package com.aimerrhythms.springcloud.consumer02.controller;

import com.aimerrhythms.springcloud.consumer02.service.HealthStatusService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/22 23:08
 */
@RestController
@RequestMapping("/eureka")
public class EurekaConsumerController01 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private HealthStatusService healthStatusService;

    @Autowired
    private LoadBalancerClient lb;

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

        /* com.netflix.discovery.EurekaClient */
        return map;
    }

    @GetMapping("/ESHealthCheck")
    public String ESHealthCheckTest(@RequestParam("status") Boolean status) {
        healthStatusService.setStatus(status);
        //调用health方法，根据status状态决定是否下线服务
        Health health = healthStatusService.health();
        return healthStatusService.getStatus() + "";
    }

    /**
     * 使用RestTemplate调用远程服务
     *
     * @return
     */
    @GetMapping("/restTemplate")
    public Map<String, String> restTemplate() {
        Application app = eurekaClient.getApplication("provider");
        List<InstanceInfo> ins = app.getInstances();
        RestTemplate template = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        if (ins != null && ins.size() > 0) {
            //获取所有注册的provider服务，然后都会进行调用
            //也可以选择一个调用
            for (InstanceInfo info : ins) {
                InstanceInfo.InstanceStatus status = info.getStatus();
                if (InstanceInfo.InstanceStatus.UP == status) {
                    String hostName = info.getHostName();
                    int port = info.getPort();
                    String url = "http://" + hostName + ":" + port + "/provider";
                    String res = template.getForObject(url, String.class);
                    map.put(hostName + ":" + port, res);
                }
            }
        }
        return map;
    }

    /**
     * 使用RestTemplate结合负载均衡调用远程服务
     *
     * @return
     */
    @GetMapping("/lb")
    public String lb() {
        //直接使用lb客户端就可以根据预设的负载均衡算法选取一个合法的provider
        //lb走的是ribbon
        ServiceInstance provider = lb.choose("provider");
        String host = provider.getHost();
        int port = provider.getPort();
        RestTemplate template = new RestTemplate();
        String url = "http://" + host + ":" + port + "/provider";
        return template.getForObject(url, String.class);
    }
}
