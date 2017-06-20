package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/16
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(value = "compute-service", fallback = FeignClientHystrix.class)
public interface FeignClientI {

    /**
     * 本例调用的是springcloud-learn-service-1模块的方法
     * 如果需要监控springcloud-learn-service-1中的方法，需要：
     * 1.springboot使用：
     *   <parent>
     *       <groupId>org.springframework.boot</groupId>
     *       <artifactId>spring-boot-starter-parent</artifactId>
     *       <version>1.5.4.RELEASE</version>
     *       <relativePath/> <!-- lookup parent from repository -->
     *   </parent>
     * 2.版本冲裁修改为：
     *   <version>Dalston.SR1</version>
     * 3.加入三个HystrixDashboard的依赖
     * 4.主类开启监控：
     *   @EnableHystrixDashboard + @EnableCircuitBreaker
     * 5.在需要监控的目标方法上加@HystrixCommand
     *
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
