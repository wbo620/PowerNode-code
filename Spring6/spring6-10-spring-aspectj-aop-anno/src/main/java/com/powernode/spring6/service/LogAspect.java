package com.powernode.spring6.service;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("LogAspect")
@Aspect//切面类是需要使@Aspect注解进行标注的。
@Order(1)//@Order注解的value指定一个整数型的数字，数字越小，优先级越高
public class LogAspect {//切面
    // 切面=通知+切点
    //通知就是增强，就是具体的要编写增强代码
    //这里通知Advice以方法的形式出现。（因为方法中可以写代码）
    //@Before注解标注的方法就是一个前置通知。

    //定义通用的切点表达式
    @Pointcut("execution(* com.powernode.spring6.service..*())")
    public void 通用切点(){
//这个方法只是一个标记，方法名随意，方法体中也不需要写任何代码。
    }

    //前置通知
    @Before("通用切点()")
    public void berforeAdvice(JoinPoint joinPoint) {
        System.out.println("前置通知·");
        //Signature signature = joinPoint.getSignature(); 获取目标方法的方法名
        //System.out.println(joinPoint.getSignature().getName());
    }
    //后置通知
    @AfterReturning("通用切点()")
    public void afterReturningAdvice() {
        System.out.println("后置通知·");
    }
    //环绕通知
    @Around("通用切点()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕");
        joinPoint.proceed();
        System.out.println("后环绕");
    }
    //异常通知
    @AfterThrowing("execution(* com.powernode.spring6.service.UserService.*(..))")
    public void afterThrowingAdvice() {
        System.out.println("异常通知·");
    }
    //最终通知
    @After("execution(* com.powernode.spring6.service.UserService.*(..))")
    public void afterAdvice() {
        System.out.println("最终通知");
    }
}