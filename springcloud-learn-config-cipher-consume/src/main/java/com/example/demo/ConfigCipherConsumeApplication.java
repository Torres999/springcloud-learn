package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 必须先启动config-cipher-server
 */
@SpringBootApplication
public class ConfigCipherConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCipherConsumeApplication.class, args);
	}
}
