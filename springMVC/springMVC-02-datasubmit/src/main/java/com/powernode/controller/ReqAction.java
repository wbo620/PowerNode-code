package com.powernode.controller;

import com.powernode.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.naming.Name;
/**
 * User: hallen
 * Date: 2023/8/2
 * Time: 20:56
 * @author hallen
 */
@Controller
public class ReqAction {

    @RequestMapping(value = "/req.action", method = RequestMethod.GET)
    public String reqGet() {
        System.out.println("get请求");
        return "get";
    }

    @RequestMapping(value = "/req.action", method = RequestMethod.POST)
    public String reqPost() {
        System.out.println("post请求");
        return "post";
    }
    /**
     *姓名:<input type="text" name="myname">
     *年龄:<input type="text" name="age">
     */
    @RequestMapping(value = "/one.action", method = RequestMethod.POST)
    public String oneDataSubmit(String myname, Integer age) {
        System.out.println("myname:" + myname + ", age:" + age);
        return "main";
    }
    /**
     *姓名:<input type="text" name="myname">
     *年龄:<input type="text" name="age">
     */
    @RequestMapping(value = "/two.action", method = RequestMethod.POST)
    public String twoDataSubmit(User user) {
        System.out.println(user);
        return "main";
    }

    /**
     * <h2>第三种数据提交方式:占位符数据提交</h2>
     * <a href="${pageContext.request.contextPath}/three/张三/13.action" >提交</a>
     */
    @RequestMapping(value = "/three/{uname}/{uage}.action")
    public String threeDataSubmit(@PathVariable("uname") String name, @PathVariable("uage") int age) {
        System.out.println("name:" + name + ", age:" + age);
        return "main";
    }
  /*  这种方式可以封装进pojo类中
    @RequestMapping(value = "/three/{name}/{age}.action")
    public String threeDataSubmit(User user) {
        System.out.println(user);
        return "main";
    }*/


    //姓名:<input type="text" name="name">
    //年龄:<input type="text" name="age">

    @RequestMapping(value = "/four.action")
    public String fourDataSubmit(
            @RequestParam("name")
            String uname,
            @RequestParam("age")
            int uage) {
        System.out.println("name:" + uname + ", age:" + uage);
        return "main";
    }

    @RequestMapping(value = "/five.action")
    public String fiveDataSubmit(HttpServletRequest request){
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        System.out.println("name:" + name + ", age:" + age);
        return "main";
    }

}
