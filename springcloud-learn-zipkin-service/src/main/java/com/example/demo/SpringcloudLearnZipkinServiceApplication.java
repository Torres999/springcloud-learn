package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudLearnZipkinServiceApplication {
    Logger logger = LoggerFactory.getLogger(SpringcloudLearnZipkinServiceApplication.class);

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudLearnZipkinServiceApplication.class, args);
    }

    @RequestMapping(value = "/zipkinService")
    public int zipkinService1(Integer a) {
        logger.info("receive a request, Parameter is :" + a);
        return a + 1;
    }

    @RequestMapping("/service2")
    public String hi() throws Exception {
        logger.info("service2");
        return "service2";
    }
}
