package com.powernode.webmvcconfig.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 21:57
 */

public class AdminInterceptor implements HandlerInterceptor {

    private final String Admin_username = "zhangsan";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("管理员权限拦截器");
        //登录的用户
        String loginUser = request.getParameter("loginUser");
        //获取请求的url地址
        String requestURI = request.getRequestURI();
        //当用户是Admin_username,并且路径是以下路径是,不拦截,否则拦截器生效
        if (Admin_username.equals(loginUser) &&
                (requestURI.startsWith("/admin/add") ||
                        requestURI.startsWith("/admin/update") ||
                        requestURI.startsWith("/admin/delete"))) {
            return true;

        }
        return false;
    }
}
