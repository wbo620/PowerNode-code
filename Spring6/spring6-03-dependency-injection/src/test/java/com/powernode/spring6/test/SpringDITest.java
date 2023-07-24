package com.powernode.spring6.test;

import com.powernode.spring6.bean.Person;
import com.powernode.spring6.bean.QianDaYe;
import com.powernode.spring6.bean.SimpleValueType;
import com.powernode.spring6.jdbc.MyDataSources;
import com.powernode.spring6.service.CustomerService;
import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {

    @Test
    public void testProperties(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSources ds = applicationContext.getBean("ds", MyDataSources.class);
        System.out.println(ds);
    }
    @Test
    public void testAutoWireDI(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
        System.out.println(userServiceBean);
    }
    @Test

    public void testCollectionDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person preson = applicationContext.getBean("personBean", Person.class);
        System.out.println(preson);
    }

    @Test
    public void testArrayDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe aihao = applicationContext.getBean("aihao", QianDaYe.class);
        System.out.println(aihao);
    }

    @Test
    public void testSimpleDateDi() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);

    }

    @Test
    public void testConstructerDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();

        CustomerService customerService2 = applicationContext.getBean("customerService2", CustomerService.class);
        customerService2.save();


        CustomerService customerService3 = applicationContext.getBean("customerService3", CustomerService.class);
        customerService3.save();
    }

    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();

        userService.saveVip();


    }
}
