package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilinlin on 2017/3/22.
 */
@RestController
public class ComputeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
//    @ApiOperation(value = "校验手机号码是否有效", notes = "校验手机号码唯一性", response = CheckTelResp.class, tags = {
//            "User/inner",})
//    @RequestMapping(value = "/user/checkTel",
//            produces = {"application/json"},
//            headers = "content-type=application/x-www-form-urlencoded",
//            method = RequestMethod.POST)
//    ResponseEntity<CheckTelResp> userCheckTelPost(
//            @ApiParam(value = "电话号码", required = true) @RequestParam(value = "telephone", required = true) String telephone);



    @HystrixCommand
    @ApiOperation(value = "计算两个数字的和")
    @ApiResponses(@ApiResponse(code = 200, message = "返回计算结果", response = Integer.class))
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    public Integer add(@ApiParam(value = "计算因子a", required = true)@RequestParam Integer a,
                       @ApiParam(value = "计算因子b", required = true)@RequestParam Integer b,
                       @RequestParam(required = false) Integer c) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a - b;
        logger.info("/add, host:" + instance.getHost() + ":" + instance.getPort() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}
