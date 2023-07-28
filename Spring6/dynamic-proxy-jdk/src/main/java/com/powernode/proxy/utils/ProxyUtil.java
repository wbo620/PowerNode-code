package com.powernode.proxy.utils;

import com.powernode.proxy.service.OrderService;
import com.powernode.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , new TimerInvocationHandler(target));

    }
}
