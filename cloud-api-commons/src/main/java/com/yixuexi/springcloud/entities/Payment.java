package com.yixuexi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @date: 2021/4/5   0:49
 * @author: 易学习
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
