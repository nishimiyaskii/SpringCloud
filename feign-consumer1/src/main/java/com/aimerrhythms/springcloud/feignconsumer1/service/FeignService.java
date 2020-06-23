package com.aimerrhythms.springcloud.feignconsumer1.service;

import com.aimerrhythms.springcloud.feignapi.pojo.Person;
import com.aimerrhythms.springcloud.feignapi.service.FeignAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/5 22:58
 */
@FeignClient(name = "feign-provider")
public interface FeignService extends FeignAPI {

    //可以对API进行拓展

    /**
     * get接收1个参数，返回一个map
     *
     * @param id
     * @return
     */
    @GetMapping("/getMap1")
    Map<String, Integer> getMap1(@RequestParam("id") Integer id);


    /**
     * get接收2个参数，返回一个map
     *
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/getMap2")
    Map<String, Person> getMap2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    /**
     * get接收一个map，返回一个map
     *
     * @param map
     * @return
     */
    @GetMapping("/getMap3")
    Map<String, Object> getMap3(@RequestParam Map<String, Object> map);

    /**
     * post接收一个map，返回一个map
     *
     * @param map
     * @return
     */
    @PostMapping("/postMap")
    Map<String, Object> postMap(@RequestBody Map<String, Object> map);


    /**
     * 接收Person对象，返回Person
     *
     * @param person
     * @return
     */
    @PostMapping("/getPerson") //实体类对象只能用post的json传
    Person getPerson(@RequestBody Person person);

}
