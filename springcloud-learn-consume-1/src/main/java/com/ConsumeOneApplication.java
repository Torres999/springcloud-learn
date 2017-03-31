package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * maven package用，没实际意义，需要放开各自包中的Application，应该四个
 * Created by lilinlin on 2017/3/22.
 */
@SpringBootApplication
public class ConsumeOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeOneApplication.class, args);
    }
}
