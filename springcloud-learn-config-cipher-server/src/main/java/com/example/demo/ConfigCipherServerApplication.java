package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 使用前提: 在使用spring cloud config的加密解密功能时，为了启动该功能，需要在配置中心环境安装jce（Unlimited Strength
 *  Jurisdiction Policy）。虽然，jce是jdk自带的，但是默认使用的是有长度限制的版本。在oracle的官方网站下载它，下载地址：
 # https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCipherServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCipherServerApplication.class, args);
	}
}
