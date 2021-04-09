package com.yixuexi.springcloud.service;

/**
 * @date: 2021/4/7   13:43
 * @author: 易学习
 */
public interface PaymentHystrixService {

    /**
     * 测试hystrix成功
     *
     * @param id id
     * @return {@link String}
     */
    String testHystrixOk(Integer id);

    /**
     * 测试hystrix超时
     *
     * @param id id
     * @return {@link String}
     */
    String testHystrixTimeout(Integer id) throws InterruptedException;

}
