package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudLearnConfigServerCluster1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnConfigServerCluster1Application.class, args);
	}
}
