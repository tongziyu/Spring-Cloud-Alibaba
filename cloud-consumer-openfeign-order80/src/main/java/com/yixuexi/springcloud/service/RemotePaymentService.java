package com.yixuexi.springcloud.service;

import com.yixuexi.springcloud.entities.CommonResult;
import com.yixuexi.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date: 2021/4/6   22:15
 * @author: 易学习
 * @FeignClient("提供者微服务的微服务名")
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface RemotePaymentService {

    @GetMapping("/get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @RequestMapping("/get/feign/time/out")
    public String timeOut() throws InterruptedException;
}
