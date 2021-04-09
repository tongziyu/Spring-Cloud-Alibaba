package com.yixuexi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2021/4/6   12:22
 * @author: 易学习
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule(){
        // 随机算法
        return new RandomRule();
    }
}
