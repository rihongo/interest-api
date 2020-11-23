package com.rihongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class DisplayApplication {

	@Bean
	@LoadBalanced
	public WebClient.Builder WebClient(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(DisplayApplication.class, args);
	}

}
