package com.powernode.transation.service.impl;

import com.powernode.transation.mapper.ActMapper;
import com.powernode.transation.service.ActService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 18:36
 */
@Service
public class ActServiceImpl implements ActService {
    @Resource
    private ActMapper actMapper;

    //开启事物
    @Transactional
    public boolean transfer(Integer fromNo, Integer toNo, double money) {
        //获取两个账户的余额
        double fromNoMoney = actMapper.getBalance(fromNo);
        double toNoMoney = actMapper.getBalance(toNo);
        //判断转出余额是否充足
        if (fromNoMoney < money) {
            throw new RuntimeException("转出余额不足");
        }
        //两个账户的更新
        int count = actMapper.rollOut(fromNo, fromNoMoney - money);
        //模拟异常
        String s = null;
        s.toString();
        count += actMapper.inTo(toNo, toNoMoney + money);

        if (count != 2) {
            return false;
        }
        return true;
    }

    //1.调用具有事物的方法,事物失效
    public boolean transfer2(Integer fromNo, Integer toNo, double money) {
        return transfer(fromNo, toNo, money);
    }

    //2.开启新的线程,在新的线程中执行业务,事物也失效
    @Transactional
    @Override
    public boolean otherThread(Integer fromNo, Integer toNo, double money) {

        System.out.println("start父线程: " + Thread.currentThread().getId());

        Thread thread = new Thread(() -> {
            System.out.println("start子线程: " + Thread.currentThread().getId());
            double fromNoMoney = actMapper.getBalance(fromNo);
            double toNoMoney = actMapper.getBalance(toNo);
            //判断转出余额是否充足
            if (fromNoMoney < money) {
                throw new RuntimeException("转出余额不足");
            }
            //两个账户的更新
            int count = actMapper.rollOut(fromNo, fromNoMoney - money);
            //模拟异常
            String s = null;
            s.toString();
            count += actMapper.inTo(toNo, toNoMoney + money);
            System.out.println("end子线程: " + Thread.currentThread().getId());
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end父线程: " + Thread.currentThread().getId());
        return true;
    }


}
