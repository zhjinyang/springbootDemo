package com.codeyancy.cn.config;

import com.codeyancy.cn.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zjy
 * @date 2021/4/13 9:34
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "login.html");
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        interceptor.addPathPatterns("/**");
        interceptor.excludePathPatterns(
                "/login/getEmailCode",
                "/login/doLogin",
                "/",                       //  /
                "/login.html",            //登录
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css"             //css静态资源
               );


    }
}
