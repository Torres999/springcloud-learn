package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/30
 * Time: 下午3:35
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(value = "zipkin-service")
public interface FeignService {

    @RequestMapping(method = RequestMethod.GET, value = "/zipkinService")
    int getService(@RequestParam(value = "a") int a);
}