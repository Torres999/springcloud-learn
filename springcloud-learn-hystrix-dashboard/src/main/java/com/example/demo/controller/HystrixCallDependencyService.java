package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/17
 * Time: 下午11:25
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HystrixCallDependencyService {
    private Random random = new Random();

    /**
     * 模拟获取用户信息(通过网络调用)
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String mockGetUserInfo() {
        int randomInt = random.nextInt(10);
        if (randomInt < 8) {  //模拟调用失败情况
            throw new RuntimeException("call dependency service fail.");
        } else {
            return "UserName:lilinlin;number:" + randomInt;
        }
    }

    public String fallback() {
        return "some exception occur call fallback method.";
    }
}
