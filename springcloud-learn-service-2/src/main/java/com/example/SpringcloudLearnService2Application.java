package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

@EnableCircuitBreaker//配合controller中的@HystrixCommand、pom中的熔断相关的两个依赖测试turbine
public class SpringcloudLearnService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnService2Application.class, args);
	}
}
