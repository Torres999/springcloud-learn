//package com.hystrix;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
///**
// * Created by lilinlin on 2017/3/22.
// */
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
//public class RibbonHystrixApplication {
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(RibbonHystrixApplication.class, args);
//    }
//}
