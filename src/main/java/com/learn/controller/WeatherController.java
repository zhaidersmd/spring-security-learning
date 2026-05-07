package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WeatherController {

    @GetMapping("/health")
    public String getHealth() {
        return "Healthy";
    }

    @GetMapping("/sensitive")
    public String returnPassword(){
        return "infa@123";
    }
}
