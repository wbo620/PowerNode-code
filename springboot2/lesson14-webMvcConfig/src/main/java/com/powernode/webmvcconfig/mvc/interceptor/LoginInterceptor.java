package com.powernode.webmvcconfig.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 22:45
 */

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> premitUser = new ArrayList<>();

    public LoginInterceptor() {
        this.premitUser = Arrays.asList("lisi", "zhangsan", "admin");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("登录权限拦截器");
        String loginUser = request.getParameter("loginUser");
        if (StringUtils.hasText(loginUser) && premitUser.contains(loginUser)) {
            return true;
        }
        return false;
    }
}
