package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by lilinlin on 2017/3/22.
 */
@RestController
public class ConsumerFeignController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/hystrix-feign-add", method = RequestMethod.GET)
    public Integer add(@RequestParam(value = "timeout", required = true) Integer timeout) {
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.info("========" + localDateTime.toString());
        Integer str = computeClient.add(10, 20);
        logger.info("  " + str + "====cousumer继续执行了调用service后的代码====" + LocalDateTime.now().toString());
        return str;
    }
}