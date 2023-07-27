package com.powernode.spring6.test;

import cn.powernode.spring6.service.StudentSercive;
import cn.powernode.spring6.spring6Config;
import com.powernode.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.lang.annotation.Target;

public class IoCAnnotationTest {
    @Test
    //全注解式开发
    public void testAllAnnotations(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(spring6Config.class);
        StudentSercive stu = annotationConfigApplicationContext.getBean("studentSercive", StudentSercive.class);
        stu.del();
    }
    @Test
    public void testAutowired(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
orderService.generate();
    }
}
