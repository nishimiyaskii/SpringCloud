package com.aimerrhythms.springcloud.provider01.controller;

import org.springframework.web.bind.annotation.*;
import to.PersonTo;

import java.util.Collections;
import java.util.Map;

@RestController
public class ProviderController01 {

    @GetMapping("/provider")
    public String provider() {
        return "01";
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        return Collections.singletonMap("name", "aimerrhythms1");
    }

    @GetMapping("/getObject")
    public PersonTo getObject() {
        return new PersonTo(23, "c2", 1, "BJ");
    }

    @GetMapping("/mapParam")
    public PersonTo mapParam(@RequestParam String name) {
        return new PersonTo(23, name, 1, "BJ");
    }

    @GetMapping("/objParam")
    public PersonTo objParam(@RequestParam String name) {
        return new PersonTo(23, name, 1, "BJ");
    }

    @PostMapping("/postMapParam")
    public PersonTo postMapParam(@RequestBody Map<String, String> param) {
        String name = param.get("name");
        PersonTo to = new PersonTo();
        to.setName(name + "1");
        return to;
    }

    @GetMapping("ribbonTest")
    public String ribbonTest() {
        return "01";
    }

}
