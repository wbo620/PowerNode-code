package com.powernode.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 代替xml文件
@ComponentScan({"com.powernode.spring6.service"}) // 组件扫描
@EnableAspectJAutoProxy(exposeProxy = true) //启用aspect自动代理机制
public class Spring6Config {

}
