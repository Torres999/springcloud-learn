package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilinlin on 2017/3/22.
 */
@RestController
public class ConsumerFeignController {
    @Autowired
    ComputeClient computeClient;
    @RequestMapping(value = "/feign-add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}