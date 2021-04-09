package com.yixuexi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2021/4/7   14:24
 * @author: 易学习
 */
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class HystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain80.class,args);
    }
}
