package com.powernode.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)//@Order注解的value指定一个整数型的数字，数字越小，优先级越高
public class SecurityAspect {
    @Before("execution(* com.powernode.spring6.service.UserService.*(..))")
    public void berforeAdvice() {
        System.out.println("前置通知:安全");
    }
}
