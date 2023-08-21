package com.powernode.servletfilter.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.*;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 16:53
 */

/**
 * @WebServlet:等同web.Xml中有关Servlet的声明
 * <servlet>
 * <servlet-name>Login</servlet-name>
 * <servlet-class>xxxx</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>Login</servlet-name>
 * <url-pattern>/home/login</url-pattern>
 * </servlet-mapping>
 */
//@WebServlet(urlPatterns = "/home/login", name = "Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Login");
        out.flush();
        out.close();
    }
}
