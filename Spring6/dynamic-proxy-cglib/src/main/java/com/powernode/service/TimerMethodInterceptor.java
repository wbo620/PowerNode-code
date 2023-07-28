package com.powernode.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object tagert, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long begin = System.currentTimeMillis();
        Object reValue = methodProxy.invokeSuper(tagert, objects);
        long end = System.currentTimeMillis();
        System.out.println("执行用时:" + (end - begin));
        return reValue;
    }
}
