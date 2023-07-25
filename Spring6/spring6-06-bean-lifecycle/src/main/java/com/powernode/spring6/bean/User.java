package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean, DisposableBean {
    private String name;


    public User() {
        System.out.println("1.实例化");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.Bean的属性赋值");
    }

    public void initBean()  {
        System.out.println("6.初始化Bean");
    }

    public void destroyBean() {
        System.out.println("10.销毁Bean");
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3.类加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3.Bean工厂：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3.bean名字：" + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9.DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.afterPropertiesSet执行");
    }
}
