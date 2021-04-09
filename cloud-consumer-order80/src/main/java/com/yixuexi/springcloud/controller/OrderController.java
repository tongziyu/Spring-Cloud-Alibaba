package com.yixuexi.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.yixuexi.springcloud.entities.CommonResult;
import com.yixuexi.springcloud.entities.Payment;
import com.yixuexi.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


/**
 * @date: 2021/4/5   12:15
 * @author: 易学习
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/get/lb",String.class);
    }


    @PostMapping("/consumer/create/payment")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        String url = "http://cloud-payment-service/create/payment";
        //使用 postForEntity 内部发的是post请求
        ResponseEntity<CommonResult> commonResultResponseEntity =
                restTemplate.postForEntity(url, payment, CommonResult.class);

         return commonResultResponseEntity.getBody();

    }

    @GetMapping("/consumer/get/payment/{id}")
    public CommonResult<Payment> get(@PathVariable Long id){
        String url = "http://cloud-payment-service/get/payment/";
        // getForObject() 内部发get 请求
        return restTemplate.getForObject(url+id,CommonResult.class);
    }
}
