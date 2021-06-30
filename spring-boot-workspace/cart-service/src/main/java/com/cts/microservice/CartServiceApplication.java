package com.cts.microservice;

import org.apache.http.entity.ContentType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public RequestInterceptor authInterceptor() {
		return(
				request->{
					request.header("auth", "This is a Header...");
					request.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
					log.info("Header Sent");
					
				}
				
				);
				
	}

}
