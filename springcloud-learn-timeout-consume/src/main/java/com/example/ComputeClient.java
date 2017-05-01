package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lilinlin on 2017/3/22.
 */
@FeignClient(value = "timeout-compute-service", fallback = ComputeClientHystrix.class)
//@FeignClient(value = "compute-service")
public interface ComputeClient {
    //此RequestMapping是用来请求服务提供这的requestMapping的，如果地址配有匹配到，抱404错误；
    //该案例中不会，因为有里hystrix和fallback
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
