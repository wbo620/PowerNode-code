package com.powernode.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class SecurotyLogAspect {
    @Pointcut("execution(* com.powernode.spring6.biz..save*(..))")
    public void savePointcut() {
    }
    @Pointcut("execution(* com.powernode.spring6.biz..modify*(..))")
    public void modifyPointcut() {
    }
    @Pointcut("execution(* com.powernode.spring6.biz..get*(..))")
    public void getPointcut() {
    }
    @Pointcut("execution(* com.powernode.spring6.biz..delete*(..))")
    public void deletePointcut() {
    }

    @Before("deletePointcut()||getPointcut()||savePointcut()||modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = sdf.format(new Date());
        System.out.println(nowTime+"张三 :"+joinPoint.getSignature().getDeclaringTypeName());

    }
}
