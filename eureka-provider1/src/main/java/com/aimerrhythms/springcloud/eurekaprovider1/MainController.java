package com.aimerrhythms.springcloud.eurekaprovider1;

import com.aimerrhythms.springcloud.eurekaprovider1.pojo.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/4 20:56
 */
@RestController
public class MainController {

    @GetMapping("/provider")
    public String provider() {
        return "provider1111";
    }

    @GetMapping("/providerMap")
    public Map<String, String> providerMap() {
        return Collections.singletonMap("name", "provider1");
    }

    @GetMapping("/providerObject01")
    public Person providerObject01() {
        return new Person("1", "aimerrhythms1", 23);
    }

    @GetMapping("/providerObject02")
    public Person providerObject02(@RequestParam("name") String name) {
        return new Person("1", name, 23);
    }

    @PostMapping("/postForLocation")
    public String postForLocation(@RequestBody Person p, HttpServletResponse resp) throws Exception {
        URI uri = new URI("https://www.baidu.com/s?wd=" + p.getName());
        //响应头必须要设置这个属性，否则取不到结果。导致空指针
        resp.addHeader("Location", uri.toString());
        return uri.toURL().toString();
    }
}
