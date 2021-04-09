package com.yixuexi.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @date: 2021/4/7   21:48
 * @author: 易学习
 * 为远程调用接口创建统一降级类
 */
@Component
public class PaymentRemoteHystrixServiceImpl implements PaymentRemoteHystrixService {
    @Override
    public String testHystrixOk(Integer id) {

        return "对方服务端以宕机!无法使用!";
    }

    @Override
    public String testHystrixTimeout(Integer id) throws InterruptedException {
        return "对方服务端以宕机,无法使用!";
    }
}
