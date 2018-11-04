package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lilinlin on 2017/3/24.
 */
@RestController
class TestController {

    @Value("${test.datasource.password}")
    private String password;

    @GetMapping("/getPassword")
    public String getPassword() {
        return this.password;
    }
}
