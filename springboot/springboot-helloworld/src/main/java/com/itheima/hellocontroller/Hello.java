package com.itheima.hellocontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: hallen
 * Date: 2023/8/13
 * Time: 20:52
 */
@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
