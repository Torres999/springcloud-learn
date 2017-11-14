package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
@LoadSelfServlet//方式2，通过@WebServlet注解+@ServletComponentScan注解
@ServletComponentScan
public class SpringcloudLearnConfigServerApplication {

    @LoadSelfServlet//方式1，代码注册
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/self/*");// ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudLearnConfigServerApplication.class, args);
    }
}
