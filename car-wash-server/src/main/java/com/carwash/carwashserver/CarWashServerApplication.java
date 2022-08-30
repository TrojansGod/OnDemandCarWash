package com.carwash.carwashserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
@EnableConfigurationProperties
public class CarWashServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWashServerApplication.class, args);
	}

}
