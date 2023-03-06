package com.programming.techie.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}
	// now to enable the eureka serveer
	// we just need to add
	// @EnableEurekaServer annotation
	// that's all we need to do to create the eureka server


	// and for the eureka clients to get
	// registered with our eureka server
	// we just need to add
	// @EnableEurekaClient Annoations
	// and the spring-started-cloud-netfix-eureka-client dependency
}
