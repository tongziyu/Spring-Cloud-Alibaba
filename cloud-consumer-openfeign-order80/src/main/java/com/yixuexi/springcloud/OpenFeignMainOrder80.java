package com.yixuexi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2021/4/6   22:04
 * @author: 易学习
 */
@SpringBootApplication
@EnableFeignClients  // 启用Feign功能
public class OpenFeignMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMainOrder80.class,args);

    }
}
