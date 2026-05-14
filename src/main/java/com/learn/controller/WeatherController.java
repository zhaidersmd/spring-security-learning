package com.learn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAuthority('WEATHER_READ')")
    @GetMapping("/weather")
    public String getWeather() {
        return "cool";
    }

    @PreAuthorize("hasAuthority('WEATHER_WRITE')")
    @PostMapping("/weather/add")
    public String addWeather(){
        System.out.println(">>> REAL SECURED METHOD HIT");
        return "new weather details added";
    }

    @GetMapping("/debug")
    public String debug() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();



        return "ok";
    }
}
