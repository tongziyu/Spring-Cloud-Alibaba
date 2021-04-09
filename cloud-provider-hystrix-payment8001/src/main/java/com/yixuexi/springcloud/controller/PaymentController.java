package com.yixuexi.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yixuexi.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/4/7   13:45
 * @author: 易学习
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping("/test/hystrix/ok/{id}")
    public String testHystrixOk(@PathVariable("id") Integer id){
        return paymentHystrixService.testHystrixOk(id);
    }

    // 三秒以内执行完毕就是正常的业务逻辑,如果超过三秒 就去执行备用方法
    @HystrixCommand(fallbackMethod = "testHystrixTimoutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    @RequestMapping("/test/hystrix/timeout/{id}")
    public String testHystrixTimeout(@PathVariable("id") Integer id) throws InterruptedException {
        int i = 10 / 0;
        return paymentHystrixService.testHystrixTimeout(id);
    }

    public String testHystrixTimoutFallback(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentHystrixService.testHystrixTimeout(id) + "降级服务方法执行!";
    }

    @HystrixCommand(fallbackMethod = "testRongDuan_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")}//失败率达到多少后跳闸
    )
    @RequestMapping("/test/hystrix/rongduan/{id}")
    public String testRongDuan(@PathVariable Integer id){
        if (id < 0){
            // 这样做的目的是让他去执行兜底方法
            throw new RuntimeException("id 不能为负数");
        }
        return "服务执行成功! id: " + id;
    }

    public String testRongDuan_fallback(@PathVariable Integer id){

        return "id 不能为负数,降级服务执行…………  id:" + id;
    }
}
