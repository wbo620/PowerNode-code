package com.powernode.proxy;

public class OrderServiceProxy implements OrderService {

    private OrderService target;

    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        long star = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - star));
    }

    @Override
    public void modify() {
        long star = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - star));
    }

    @Override
    public void detail() {
        long star = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - star));
    }
}
