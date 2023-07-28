package com.powernode.proxy;

public class OrderServiceImpl implements OrderService{
    @Override
    public void generate() {
        //模拟运行耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("创建订单中");
    }

    @Override
    public void modify() {
        //模拟运行耗时
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("查询订单");
    }

    @Override
    public void detail() {
        //模拟运行耗时
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单详情");
    }
}
