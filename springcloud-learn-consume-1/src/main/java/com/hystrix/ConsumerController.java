package com.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by lilinlin on 2017/3/22.
 */
@RestController
public class ConsumerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ComputeService computeService;
    @RequestMapping(value = "/hystrix-add", method = RequestMethod.GET)
    public String add() {
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.info("=========" + localDateTime.toString());
        String str = computeService.addService();
        str = str + " cousumer继续执行了调用service后的代码";
        logger.info("====str=====" + LocalDateTime.now().toString() + "  " + str);
        return str;
    }
}
