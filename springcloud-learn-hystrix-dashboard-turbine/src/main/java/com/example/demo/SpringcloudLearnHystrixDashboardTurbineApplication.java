package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 该工程测试用到了以下模块：
 * 1.springcloud-learn-consume-1
 * 2.springcloud-learn-registercenter
 * 3.springcloud-learn-service-1
 * 4.springcloud-learn-service-2
 * 5.springcloud-learn-hystrix-dashboard-turbine
 */

@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class SpringcloudLearnHystrixDashboardTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnHystrixDashboardTurbineApplication.class, args);
	}
}
