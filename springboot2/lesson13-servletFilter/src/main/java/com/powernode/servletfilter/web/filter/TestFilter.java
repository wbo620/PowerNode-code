package com.powernode.servletfilter.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 18:04
 */

public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取请求地址
        String url = ((HttpServletRequest) request).getRequestURI().toString();
        System.out.println("Test过滤器执行了: " + url);
        chain.doFilter(request, response);
    }
}
