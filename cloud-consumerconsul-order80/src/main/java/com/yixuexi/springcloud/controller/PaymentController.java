package com.yixuexi.springcloud.controller;

import com.yixuexi.springcloud.entities.CommonResult;
import com.yixuexi.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @date: 2021/4/6   8:58
 * @author: 易学习
 */
@RestController
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/get/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        String url = "http://cloud-payment-service/get/payment/" + id;

        return restTemplate.getForObject(url,CommonResult.class);
    }

}
