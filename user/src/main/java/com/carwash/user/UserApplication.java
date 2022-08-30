package com.carwash.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.carwash.user.models.Customer;
import com.carwash.user.repositories.UserRepository;

//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.carwash.user") //to scan packages mentioned
@EnableMongoRepositories("com.carwash.user") //to activate MongoDB repositories

public class UserApplication implements CommandLineRunner{
	
	private final UserRepository userRepository;
	
	// To connect the userRepository
	@Autowired
	public UserApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// Main application for user microservice
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate GetTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()) {
			userRepository.save(new Customer("Ayush", "Khamrui", "khamruiasok@gmail.com","Barakar","12345","Tesla"));
			userRepository.save(new Customer("Tuhin", "gosh", "tuhin@gmail.com","Ba","12345","Tesla model x"));
		}
		
		for(Customer customer: userRepository.findAll()) {
			System.out.println(customer);
		}
	}

}
