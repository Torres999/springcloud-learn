package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/16
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
@Component
public class FeignClientHystrix implements FeignClientI {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
