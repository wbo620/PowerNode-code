package com.powernode.webmvcconfig.mvc.settings;

import com.powernode.webmvcconfig.mvc.interceptor.AdminInterceptor;
import com.powernode.webmvcconfig.mvc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 18:42
 */

/**
 * SpringMVC.配置：使用JavaConfig.的方式配置SpringMVC,代替原来的xml配置文件
 */
@Configuration
public class MvcSettings implements WebMvcConfigurer {
    //页面跳转控制器，从请求直达视图页面（无需controller)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置页面控制：addViewController("请求uri"),指定他的视图setViewName(目标视图)
        registry.addViewController("/welcome").setViewName("index");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AdminInterceptor adminInterceptor = new AdminInterceptor();
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(adminInterceptor)
                .order(2)//执行顺序,数字越小先执行
                .addPathPatterns("/admin/**")  //拦截地址
                .excludePathPatterns("/admin/select"); //不拦截地址

        registry.addInterceptor(loginInterceptor)
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/select"); //不拦截地址;
    }
}
