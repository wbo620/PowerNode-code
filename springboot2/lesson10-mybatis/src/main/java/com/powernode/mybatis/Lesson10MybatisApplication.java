package com.powernode.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.powernode.mybatis.mapper")

@SpringBootApplication
public class Lesson10MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson10MybatisApplication.class, args);
    }

}
