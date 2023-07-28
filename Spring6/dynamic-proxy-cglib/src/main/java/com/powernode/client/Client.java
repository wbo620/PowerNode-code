package com.powernode.client;

import com.powernode.service.TimerMethodInterceptor;
import com.powernode.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();

        enhancer.setSuperclass(UserService.class);

        enhancer.setCallback(new TimerMethodInterceptor());

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.login("admin","123");
        userServiceProxy.logout();
    }
}
