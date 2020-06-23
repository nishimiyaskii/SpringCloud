package com.aimerrhythms.springcloud.resttemplate.controller;

import com.aimerrhythms.springcloud.resttemplate.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/5 20:47
 */
@RestController
public class MainController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 返回object
     * @return
     */
    @GetMapping("/restTemplate1")
    public String restTemplate1() {
        //   hostname/uri
        String url = "http://provider/provider";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 返回实例
     * @return
     */
    @GetMapping("/restTemplate2")
    public ResponseEntity<String> restTemplate2() {
        String url = "http://provider/provider";

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        System.out.println(entity);

        return entity;
    }

    /**
     * 返回map
     * @return
     */
    @GetMapping("/restTemplate3")
    public Map<String, String> restTemplate3() {
        String url = "http://provider/providerMap";
        Map<String, String> map = restTemplate.getForObject(url, Map.class);
        System.out.println(map);
        return map;
    }

    /**
     * 返回确定的单个实例对象（provider创建的）
     * @return
     */
    @GetMapping("/restTemplate4")
    public Object restTemplate4() {
        String url = "http://provider/providerObject01";
        Person person = restTemplate.getForObject(url, Person.class);
        return person;
    }

    /**
     * 占位符传参的方式调用
     * @return
     */
    @GetMapping("/restTemplate5")
    public Object restTemplate5() {
        //这里使用占位符
        String url = "http://provider/providerObject02?name={1}";
        Person person = restTemplate.getForObject(url, Person.class, "aimerrhythms2");
        return person;
    }


    /**
     * map传参的方式调用
     * @return
     */
    @GetMapping("/restTemplate6")
    public Object restTemplate6() {
        //这里的占位符必须和map的key一直，否则注入不进去
        String url = "http://provider/providerObject02?name={name}";
        Map<String, String> map = Collections.singletonMap("name", "aimerrhythms3");
        Person person = restTemplate.getForObject(url, Person.class, map);
        return person;
    }

    /**
     * POST请求：需要注意的一个方法：postForLocation
     * @return
     */
    @GetMapping("/restTemplate7")
    public Object restTemplate7(HttpServletResponse resp) throws Exception {
        String url = "http://provider/postForLocation";
        URI uri = restTemplate.postForLocation(url, Collections.singletonMap("name", "nishimiya"), Person.class);
        resp.sendRedirect(uri.toURL().toString());
        return uri;
    }



}
