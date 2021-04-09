package com.yixuexi.springcloud.service.impl;

import com.yixuexi.springcloud.dao.PaymentDao;
import com.yixuexi.springcloud.entities.Payment;
import com.yixuexi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date: 2021/4/5   1:24
 * @author: 易学习
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
