package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/30
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class ZipkinController {
    Logger logger = LoggerFactory.getLogger(ZipkinController.class);

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/zipkin", method = RequestMethod.GET)
    public int client(@RequestParam int b) {
        logger.info("Begin Zipkin Controller process!" + "Parameter is:" + b);
        return feignService.getService(b);
    }

    @Autowired
    private RestTemplate restTemplate;

    private String url="http://localhost:9412";

    @RequestMapping("/service1")
    public String service1() throws Exception {
        logger.info("service1");
        String s = this.restTemplate.getForObject(url + "/service2", String.class);
        return s;
    }
}
