package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication


@Configuration
@EnableAutoConfiguration
@ComponentScan

@EnableCircuitBreaker//配合controller中的@HystrixCommand、pom中的熔断相关的两个依赖测试turbine
public class SpringcloudLearnService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnService1Application.class, args);
	}
}
