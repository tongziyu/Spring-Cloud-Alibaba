package com.yixuexi.springcloud;

import com.yixuexi.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @date: 2021/4/5   11:59
 * @author: 易学习
 */
@EnableEurekaClient
@SpringBootApplication
// name 写要负载均衡访问的provider的微服务名字
//@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
