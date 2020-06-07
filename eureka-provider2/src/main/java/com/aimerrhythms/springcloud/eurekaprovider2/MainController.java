package com.aimerrhythms.springcloud.eurekaprovider2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author aimerrhythms
 * @data 2020/6/4 21:06
 */
@RestController
public class MainController {

    @GetMapping("/provider")
    public String provider() {
        return "provider2222";
    }

    @GetMapping("/providerMap")
    public Map<String, String> providerMap() {
        return Collections.singletonMap("name", "provider2");
    }

}
