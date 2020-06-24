package com.aimerrhythms.springcloud.consumer02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import to.PersonTo;

import java.util.Collections;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/23 23:08
 */
@RestController
@RequestMapping("/rest")
public class RESTfulController01 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/restTemplate")
    public String restTemplate() {
        String url = "http://provider/provider";
        return restTemplate.getForObject(url, String.class);
    }


    /**
     * getForEntity返回map
     *
     * @return
     */
    @GetMapping("/getMap")
    public Map<String, String> getMap1() {
        String url = "http://provider/getMap";
        return restTemplate.getForEntity(url, Map.class).getBody();
    }

    /**
     * getForEntity返回object
     *
     * @return
     */
    @GetMapping("/getObject")
    public PersonTo getObject() {
        String url = "http://provider/getObject";
        return restTemplate.getForEntity(url, PersonTo.class).getBody();
    }

    /**
     * getForEntity传参：map
     *
     * @return
     */
    @GetMapping("/mapParam")
    public PersonTo mapParam() {
        //占位符必须和map的key相同，否则无法注入
        //provider使用@RequestParma注解接收参数
        String url = "http://provider/mapParam?name={name}";
        return restTemplate.getForEntity(url, PersonTo.class, Collections.singletonMap("name", "chenxi")).getBody();
    }

    /**
     * getForEntity传参：object
     *
     * @return
     */
    @GetMapping("/objParam")
    public PersonTo objParam() {
        //使用占位符
        //provider使用@RequestParma注解接收参数
        String url = "http://provider/objParam?name={1}";
        return restTemplate.getForEntity(url, PersonTo.class, "chenxi").getBody();
    }

    /**
     * restTemplate处理post请求，传入map类型的参数
     *
     * @return
     */
    @PostMapping("/postMapParam")
    public PersonTo postMapParam() {
        String url = "http://provider/postMapParam";
        Map<String, String> param = Collections.singletonMap("name", "chenxi");
        ResponseEntity<PersonTo> respEntity = restTemplate.postForEntity(url, param, PersonTo.class);
        return respEntity.getBody();
    }


}
