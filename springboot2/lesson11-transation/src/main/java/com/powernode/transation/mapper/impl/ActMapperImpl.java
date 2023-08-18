package com.powernode.transation.mapper.impl;

import com.powernode.transation.mapper.ActMapper;

/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 17:36
 */

public class ActMapperImpl implements ActMapper {
    @Override
    public double getBalance(Integer actNo) {
        return 0;
    }

    @Override
    public int rollOut(Integer actNo, double money) {

        return 0;
    }

    @Override
    public int inTo(Integer actNo, double money) {
        return 0;
    }
}
