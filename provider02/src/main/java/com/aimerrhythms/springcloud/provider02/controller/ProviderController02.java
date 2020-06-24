package com.aimerrhythms.springcloud.provider02.controller;

import org.springframework.web.bind.annotation.*;
import to.PersonTo;

import java.util.Collections;
import java.util.Map;

@RestController
public class ProviderController02 {

    @GetMapping("/provider")
    public String provider() {
        return "02";
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        return Collections.singletonMap("name", "aimerrhythms2");
    }

    @GetMapping("/getObject")
    public PersonTo getObject() {
        return new PersonTo(23, "c1", 1, "HN");
    }

    @GetMapping("/mapParam")
    public PersonTo mapParam(@RequestParam String name) {
        return new PersonTo(23, name, 1, "HN");
    }

    @GetMapping("/objParam")
    public PersonTo objParam(@RequestParam String name) {
        return new PersonTo(23, name, 1, "HN");
    }

    @PostMapping("/postMapParam")
    public PersonTo postMapParam(@RequestBody Map<String, String> param) {
        String name = param.get("name");
        PersonTo to = new PersonTo();
        to.setName(name + "2");
        return to;
    }

    @GetMapping("ribbonTest")
    public String ribbonTest() {
        return "02";
    }

}