package com.yixuexi.springcloud.service.impl;

import com.yixuexi.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @date: 2021/4/7   13:44
 * @author: 易学习
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String testHystrixOk(Integer id) {
        return "测试成功 + testHystrixOk() -->" + id;
    }

    @Override
    public String testHystrixTimeout(Integer id) throws InterruptedException {
        // Thread.sleep(3000);

        return "测试成功 + testHystrixTimeout() -->" + id ;
    }
}
