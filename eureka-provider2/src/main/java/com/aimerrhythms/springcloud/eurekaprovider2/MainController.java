package com.aimerrhythms.springcloud.eurekaprovider2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
