package com.powernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: hallen
 * Date: 2023/8/2
 * Time: 18:34
 */
@Controller
public class DemoAction {
@RequestMapping("/demo.action")
    public String demo(){
        System.out.println("服务器被访问到...");
        return "main";
    }
}
