package com.yixuexi.springcloud.dao;


import com.yixuexi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @date: 2021/4/5   0:55
 * @author: 易学习
 * @Mapper: 推荐使用@Mapper注解
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
