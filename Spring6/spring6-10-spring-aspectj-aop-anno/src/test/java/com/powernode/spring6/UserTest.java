package com.powernode.spring6;

import com.powernode.spring6.service.Spring6Config;
import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testNoXml(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Spring6Config.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();

    }
    @Test
    public void testUser() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login();
    }
}
