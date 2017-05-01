package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lilinlin on 2017/3/22.
 */
//不需要在Feigh工程中引入Hystix，Feign中已经依赖了Hystrix
@Component
public class ComputeClientHystrix implements ComputeClient {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        logger.info("========调用出现异常，触发熔断========");
        return -9999;
    }
}
