package com.powernode.transation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.powernode.transation.mapper")
@SpringBootApplication
public class Lesson11TransationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson11TransationApplication.class, args);
	}

}
