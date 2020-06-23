package com.aimerrhythms.springcloud.feignprovider.controller;

import com.aimerrhythms.springcloud.feignapi.pojo.Person;
import com.aimerrhythms.springcloud.feignapi.service.FeignAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author aimerrhythms
 * @data 2020/6/5 22:06
 */
@RestController
public class FeignProviderController implements FeignAPI {

    @Value("${server.port}")
    String port;

    private AtomicInteger count = new AtomicInteger(1);

    @Override
    public String alive() {


        try {
            System.out.println("业务处理中...");
            //未超时，调用成功
//            TimeUnit.MILLISECONDS.sleep(300);
            //超时，调用失败
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = count.getAndIncrement();

        System.out.println(port + "：第" + i + "次调用");

        return "port = " + port;
    }

    @Override       //不用写映射，因为可以从API中继承下来
    public String getId(@RequestParam("id") Integer id) {
        return "id = " + id;
    }

    @GetMapping("/getMap1")     //这个要写，因为这是consumer拓展的
    public Map<String, Integer> getMap1(@RequestParam("id") Integer id) {
        return Collections.singletonMap("id", id);
    }

    @GetMapping("/getMap2")
    public Map<String, Person> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        return Collections.singletonMap("person", new Person(id, name));
    }

    @GetMapping("/getMap3")
    public Map<String, Object> getMap3(@RequestParam Map<String, Object> map) {
        HashMap<String, Object> resMap = new HashMap<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            resMap.put(key, map.get(key));
        }
        return resMap;
    }

    @PostMapping("/postMap")
    public Map<String, Object> postMap(@RequestBody Map<String, Object> map) {
        HashMap<String, Object> resMap = new HashMap<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            resMap.put(key, map.get(key));
        }
        return resMap;
    }

    @PostMapping("/getPerson")
    public Person getPerson(@RequestBody Person person) {

        System.out.println(person);

        return person;
    }

}
