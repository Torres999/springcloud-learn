package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 该module没有继承父工程，因为父工程的冲裁、springboot版本不支持HystrixDashboard
 * 独立的工程（如果需要使用feginClient方式，需要启动service-1工程）
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringcloudLearnHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnHystrixDashboardApplication.class, args);
	}
}
