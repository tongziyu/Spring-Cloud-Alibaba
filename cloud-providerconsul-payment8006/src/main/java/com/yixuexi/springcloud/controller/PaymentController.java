package com.yixuexi.springcloud.controller;

import com.yixuexi.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/4/6   9:10
 * @author: 易学习
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/get/payment/{id}")
    public CommonResult get(@PathVariable("id") Long id){

        return new CommonResult(200,"",port);
    }
}
