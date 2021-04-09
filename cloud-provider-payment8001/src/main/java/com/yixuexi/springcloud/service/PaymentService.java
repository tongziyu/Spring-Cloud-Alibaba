package com.yixuexi.springcloud.service;

import com.yixuexi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @date: 2021/4/5   1:24
 * @author: 易学习
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
