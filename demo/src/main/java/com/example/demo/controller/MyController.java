package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
public class MyController {
    @GetMapping("/getSomething")
    public String getSomething(){
        System.out.println("ohhhh");
        return "eee";
    }
}
