package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/16
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class FeignClientController {

    @Autowired
    FeignClientI feignClientI;

    @Autowired
    private HystrixCallDependencyService service;

    /**
     * 调用依赖的服务
     */
    @RequestMapping("/call")
    public String callDependencyService() {
        return service.mockGetUserInfo();
    }

    @HystrixCommand//加在FeignClientI或者FeignClientHystrix的方法上都无效
    @RequestMapping(value = "/hystrixDashboard/test/{i}", method = RequestMethod.GET)
//    @RequestMapping(value = "/hystrixDashboard/test", method = RequestMethod.GET)
//    public Integer add(@RequestParam("i") int i) {
    public Integer add(@PathVariable("i") int i) {
        return feignClientI.add(i, 20);
    }
}
