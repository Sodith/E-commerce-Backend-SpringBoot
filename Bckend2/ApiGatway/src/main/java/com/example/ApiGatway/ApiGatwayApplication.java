package com.example.ApiGatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableEurekaClient
public class ApiGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatwayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/authen/**").uri("http://localhost:8084/"))
				.route(p -> p.path("/user/**").uri("http://localhost:8081/"))
				.build();
	}
}