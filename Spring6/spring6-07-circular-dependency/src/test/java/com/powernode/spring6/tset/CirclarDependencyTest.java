package com.powernode.spring6.tset;

import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CirclarDependencyTest {

    //singleton+set的模式下产生的循环依赖
    //单例模式下能正常运行
    @Test
    public void testCirclarDependency1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean1.xml");
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
        Student stu = applicationContext.getBean("stu", Student.class);
        System.out.println(stu);
    }
    //prototype+set注入的方式下，循环依赖会不会出现问题？
    //非单例模式下,报错
    @Test
    public void testCirclarDependency2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean2.xml");
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
        Student stu = applicationContext.getBean("stu", Student.class);
        System.out.println(stu);
    }

}
