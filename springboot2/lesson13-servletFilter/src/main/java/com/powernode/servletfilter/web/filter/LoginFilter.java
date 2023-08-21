package com.powernode.servletfilter.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 16:54
 */
//用注解的方式创建过滤器
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取请求地址
        String url = ((HttpServletRequest) request).getRequestURI().toString();
        System.out.println("Login过滤器执行了: " + url);
        chain.doFilter(request, response);
    }
}
