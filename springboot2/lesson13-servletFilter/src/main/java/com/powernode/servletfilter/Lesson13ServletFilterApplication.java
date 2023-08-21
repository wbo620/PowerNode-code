package com.powernode.servletfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan(basePackages = "com.powernode.servletfilter.web")
@SpringBootApplication
public class Lesson13ServletFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson13ServletFilterApplication.class, args);
	}

}
