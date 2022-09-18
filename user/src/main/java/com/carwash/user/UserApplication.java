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
			userRepository.save(new Customer("khamruiasok@gmail.com","Ayush", "Khamrui", "Barakar","$2a$12$RkEdY.WQFa4RRqSGzVLjIu8osjpqZ5EwUXkMMO7t09G931MeJUDlC","Tesla","user","https://scontent-ccu1-1.xx.fbcdn.net/v/t1.6435-9/75485222_1381697542007790_4145768979769589760_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=174925&_nc_ohc=AmGZcN1Jl50AX_zwO1T&_nc_ht=scontent-ccu1-1.xx&oh=00_AT8sDhoWtRMgU6DV_kZruBN_W0OCufQ7x3S3dF3nkqaHbg&oe=63474EF7"));
			userRepository.save(new Customer("tuhin@gmail.com","Tuhin", "gosh", "Ba","$2a$12$6d8rFj.PN/P9vQltLWghJ.9U1mkXQpkwh3Jn3f.E5x12zr7xvM8pa","Tesla model x","admin","https://scontent-ccu1-1.xx.fbcdn.net/v/t1.6435-9/136647485_836047773909526_8573286469643766160_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=174925&_nc_ohc=EOCzQUxtN70AX-9Rg02&_nc_ht=scontent-ccu1-1.xx&oh=00_AT__Ma3MkGRhlQqzA5HHNZXRcOEeLBsmL1JvUoKO0QvNpg&oe=63445551"));
		}
		
		for(Customer customer: userRepository.findAll()) {
			System.out.println(customer);
		}
	}

}
