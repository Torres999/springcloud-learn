package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudLearnRegistercenterHa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnRegistercenterHa2Application.class, args);
	}
}
