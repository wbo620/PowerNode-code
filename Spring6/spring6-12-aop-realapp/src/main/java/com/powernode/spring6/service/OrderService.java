package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void generate(){
        System.out.println("创建订单...");
    }

    public void cancel(){
        System.out.println("订单已取消...");
        String s=null;
        s.toString();
    }
}
