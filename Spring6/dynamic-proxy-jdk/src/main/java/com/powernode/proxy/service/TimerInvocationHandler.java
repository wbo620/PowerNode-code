package com.powernode.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的一个调用处理器对象。
 * 在这个调用处理器当中编写计时相关的增强代码。
 * 这个调用处理器只需要写一个就行了。
 * @author hallen
 *
 */

public class TimerInvocationHandler implements InvocationHandler {
    private Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.currentTimeMillis();
        Object reValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
        return reValue;
    }
}
