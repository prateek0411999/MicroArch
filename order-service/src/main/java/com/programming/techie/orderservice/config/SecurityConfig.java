package com.programming.techie.orderservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

@EnableWebSecurity
public class SecurityConfig {

    @PostConstruct
    public void enableAuthenticationContextOnSpawnedThreads(){
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}
