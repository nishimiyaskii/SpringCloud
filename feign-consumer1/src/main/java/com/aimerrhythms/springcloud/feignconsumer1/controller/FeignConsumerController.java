package com.aimerrhythms.springcloud.feignconsumer1.controller;

import com.aimerrhythms.springcloud.feignapi.pojo.Person;
import com.aimerrhythms.springcloud.feignconsumer1.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 面向API的远程调用
 *
 * @author aimerrhythms
 * @data 2020/6/5 21:58
 */
@RestController
public class FeignConsumerController {

//    @Autowired
//    UserService1 userService1;
//
//    @Autowired
//    UserService2 userService2;

    @Autowired
    FeignService feignService;

    @GetMapping("/alive")
    public String alive() {
        return feignService.alive();
    }

    @GetMapping("/getId")
    public String getId(@RequestParam("id") Integer id) {
        return feignService.getId(id);
    }

    @GetMapping("/getMap1")
    public Map<String, Integer> getMap1(@RequestParam("id") Integer id) {
        return feignService.getMap1(id);
    }

    @GetMapping("/getMap2")
    public Map<String, Person> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        return feignService.getMap2(id, name);
    }

    @GetMapping("/getMap3")
    public Map<String, Object> getMap3(@RequestParam Map<String, Object> map) {
        return feignService.getMap3(map);
    }

    @GetMapping("/postMap")
    public Map<String, Object> postMap(@RequestParam Map<String, Object> map) {
        return feignService.postMap(map);
    }

    @GetMapping("/getPerson")
    public Person getPerson(Person person) {

        System.out.println(person);

        return feignService.getPerson(person);
    }

}
