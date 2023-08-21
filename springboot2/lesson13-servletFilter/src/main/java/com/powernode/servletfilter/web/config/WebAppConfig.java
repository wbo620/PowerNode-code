package com.powernode.servletfilter.web.config;

import com.powernode.servletfilter.web.filter.LoginFilter;
import com.powernode.servletfilter.web.filter.TestFilter;
import com.powernode.servletfilter.web.servlet.LoginServlet;
import jakarta.servlet.Filter;
import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 16:55
 */
@Configuration
public class WebAppConfig {
    /**
     * 用编码的方式创建servlet,filter
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        //创建ServletRegistrationBean 登录一个或多个servlet
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new LoginServlet());
        servletServletRegistrationBean.addUrlMappings("/home/login");
        servletServletRegistrationBean.setLoadOnStartup(1);
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //登记filter对象
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        //过滤所有页面
        filterFilterRegistrationBean.addUrlPatterns("/*");
        //有多个过滤器可以设置执行的先后顺序,数值越小越先执行
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        //登记filter对象
        FilterRegistrationBean<Filter> filterFilterRegistrationBean2 = new FilterRegistrationBean<>();
        filterFilterRegistrationBean2.setFilter(new TestFilter());
        filterFilterRegistrationBean2.addUrlPatterns("/*");
        //有多个过滤器可以设置执行的先后顺序,数值越小越先执行
        filterFilterRegistrationBean2.setOrder(-1);
        return filterFilterRegistrationBean2;
    }

    //登记框架内置的Filter
    @Bean
    public FilterRegistrationBean addCommoneLogFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
        //记录请求的uri地址
        commonsRequestLoggingFilter.setIncludeQueryString(true);
        registrationBean.setFilter(commonsRequestLoggingFilter);
        registrationBean.addUrlPatterns(("/*"));
        return registrationBean;
    }

}
