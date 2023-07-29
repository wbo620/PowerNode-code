package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void login(){
        try {
            System.out.println("正在登录...");
            //模拟异常
            //String s=null;
            //s.toString();
        } catch (Exception e) {
         throw new RuntimeException(e);
        } finally {
        }
    }
}
