package com.programming.techie.orderservice;


import com.programming.techie.orderservice.config.RequestResponseInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	// as we're making call to inventory-service from here
	// we need to pass the token right???
	// so we're intercepting the request here
	/// and adding the bearer token that is there in our SecurityContextHolder

//	@Bean
//	public RequestInterceptor requestTokenBearerInterceptor(){
//		return new RequestInterceptor() {
//			@Override
//			public void apply(RequestTemplate requestTemplate) {
//				JwtAuthenticationToken token =  (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//				requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
//			}
//		};
//	}

	@Bean
	public RestTemplate restTemplate() {

		System.out.print("@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print("@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");System.out.print("!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print("@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print("@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print("@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseInterceptor()));
		return restTemplate;
	}
}
