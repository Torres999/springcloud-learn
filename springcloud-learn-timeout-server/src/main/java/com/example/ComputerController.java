package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilinlin on 2017/5/1.
 */
@RestController
public class ComputerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b, @RequestParam(required = false) Integer c) {
        logger.info("=====Accept a request!=====");
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        配合Application中的一下命令测试：
//        hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000
        Integer r = a - b;
        logger.info("/add, result:" + r);
        return r;
    }
}
