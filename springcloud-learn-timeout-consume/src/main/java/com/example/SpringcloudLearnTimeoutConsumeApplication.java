package com.example;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudLearnTimeoutConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudLearnTimeoutConsumeApplication.class, args);
	}

	@Bean
	public Retryer retryer() {
		return new Retryer() {
			@Override
			public void continueOrPropagate(RetryableException e) {
				throw e;
			}

			@Override
			public Retryer clone() {
				return this;
			}
		};
	}
}
