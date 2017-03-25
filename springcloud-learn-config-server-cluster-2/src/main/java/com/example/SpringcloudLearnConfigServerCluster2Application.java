package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudLearnConfigServerCluster2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnConfigServerCluster2Application.class, args);
	}
}
