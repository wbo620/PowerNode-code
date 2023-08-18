package com.powernode.quickweb.controller;

import com.powernode.quickweb.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 21:53
 */
@Controller
public class HomeController {
    //定义方法处理请求，方法叫做控制器方法（处理器方法）
    //Model表示模型，存储数据。这个数据最后是放在request作用域。
    //HttpServletRequest放在的作用域中
    @RequestMapping("/home")
    public String home(Model model) {
        //将域中添加数据
        model.addAttribute("title", "Home,绑定的数据");
        model.addAttribute("time", LocalDateTime.now());

        //指定视图,展示数据
        return "home";
    }

    //SpringMVC支持控制器方法返回对象，由框架将对象使用jackson转为json,并输出
    @GetMapping("/home/json")
    @ResponseBody
    public User JsonModel() {
        User user = new User("张安", 23);
        return user;
    }

    //?只能统配一个字符
    @GetMapping("/home/t?st")
    @ResponseBody
    public String t1(HttpServletRequest request) {
        return "请求路径:" + request.getRequestURI();
    }

    //*统配0或1个字符,不能匹配路径和/
    @GetMapping("/home/t*st")
    @ResponseBody
    public String t2(HttpServletRequest request) {
        return "请求路径:" + request.getRequestURI();
    }

    //**统配所有字符,可以统配多个路径
    @GetMapping("/home/**")
    @ResponseBody
    public String t3(HttpServletRequest request) {
        return "请求路径:" + request.getRequestURI();
    }

    @GetMapping("/order/{*id}")
    @ResponseBody
    public String t4(@PathVariable("id") String orderId, HttpServletRequest request) {
        return "请求路径:" + request.getRequestURI() + ", id:" + orderId;
    }

    @GetMapping("/pages/{fname:\\w+}.log")
    @ResponseBody
    public String t5(HttpServletRequest request) {
        return "请求路径:" + request.getRequestURI();
    }
}
