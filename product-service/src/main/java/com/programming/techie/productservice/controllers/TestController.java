package com.programming.techie.productservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RefreshScope
public class TestController  {

    @Value("${test.name}")
    private String name;

    @GetMapping("/test")
    public String get_name(){
        return name;
    }
}



// @RefreshScope annotation is for configuration refresh so
// that it will automatically fetch the updated value from the config server
// we need to add actuator dependency
// as we need the actuator endpoint to trigger the refresh
//   -> /actuator/refresh to trigger the configuration refresh
// we also need to th
