package com.yixuexi.springcloud.controller;


import com.yixuexi.springcloud.entities.CommonResult;
import com.yixuexi.springcloud.entities.Payment;
import com.yixuexi.springcloud.service.RemotePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/4/6   22:30
 * @author: 易学习
 */
@RestController
public class FeignController {
    @Autowired
    private RemotePaymentService remotePaymentService;

    @GetMapping("/consumer/get/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = remotePaymentService.getPaymentById(id);
        return paymentById;
    }

    @RequestMapping("/consumer/get/feign/time/out")
    public String timeOut() throws InterruptedException{

        String s = remotePaymentService.timeOut();
        return s;
    }
}
