package com.powernode.spring6.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransationAspect {
    @Around("execution(* com.powernode.spring6.service..*(..))")
    public void aroundAspect(ProceedingJoinPoint joinpoint) {

        try {
            System.out.println("开启事物");
            joinpoint.proceed();
            System.out.println("关闭事物");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }

    }

}
