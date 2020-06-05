package com.aimerrhythms.springcloud.eurekaconsumer1.controller;

import com.aimerrhythms.springcloud.eurekaconsumer1.service.HealthStatusService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author aimerrhythms
 * @data 2020/6/4 21:09
 */
@RestController
public class MainController {

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    HealthStatusService healthStatusService;

    /**
     * 获取所有应用
     *
     * @return
     */
    @GetMapping("/client1")
    public String client1() {

        //获取所有已注册的服务实例
        Applications apps = eurekaClient.getApplications();
        List<Application> registeredApps = apps.getRegisteredApplications();

        for (Application app : registeredApps) {
            //spring.application.name
            System.out.println("app = " + app);
            List<InstanceInfo> ins = app.getInstances();
            for (InstanceInfo info : ins) {
                //eureka.instance.hostname
                System.out.println("hostname = " + info.getHostName());
            }
        }

        return "client1";
    }

    /**
     * 原生API调用远程服务：就是通过URL拼接
     *
     * @return
     */
    @GetMapping("/client2")
    public String client2() {
        Application provider = eurekaClient.getApplication("provider");

        List<InstanceInfo> ins = provider.getInstances();

        if (ins.size() > 0) {
            for (InstanceInfo info : ins) {
                String url = "http://" + info.getHostName() + ":" + info.getPort() + "/provider";
                RestTemplate restTemplate = new RestTemplate();
                String resp = restTemplate.getForObject(url, String.class);
                System.out.println("resp = " + resp);
            }
        }

        return "client2";

    }

    /**
     * 使用负载均衡做远程调用
     * @return
     */
    @GetMapping("/client3")
    public String client3() {
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/provider";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }


    /**
     * 根据业务逻辑判断是否需要对服务进行手动下线
     * @param status
     * @return
     */
    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {

        healthStatusService.setStatus(status);

        return healthStatusService.getStatus();

    }


}
