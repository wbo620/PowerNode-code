package com.powernode.blogadmin;

import com.powernode.blogadmin.settings.ArticleSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan(basePackages = "com.powernode.blogadmin.mapper")

@EnableConfigurationProperties(ArticleSettings.class)

@SpringBootApplication
public class Lesson20BlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson20BlogAdminApplication.class, args);
    }

}
