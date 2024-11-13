package com.sqc.academy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/greeting")
    public String hello(@RequestParam(defaultValue = "Ngọc Quang") String name,
                        @RequestParam(defaultValue = "Quảng Trị") String address) {
        // return "Hello " + name + " - " + address;
        return String.format("Hello %s - %s", address, name);
    }
}
