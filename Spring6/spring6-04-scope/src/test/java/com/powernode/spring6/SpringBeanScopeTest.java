package com.powernode.spring6;

import com.powernode.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {


    @Test
    public void testSpringBeanSingleton(){

        //默认条件下,bean是单例的--
        //在xml文件中设置scope属性,可以改变
        //Prototype--不是单例的
        //singleton--是单例的(默认)
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
    }

    @Test
    public void testSpringBeanPrototype() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);

    }
}
