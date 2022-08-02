package com.example.webdemo.config;

import com.example.webdemo.controller.userController;
import com.example.webdemo.fillter.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 /* @EnableWebMvc：全面接管MVC，导致自动配置类失效 */



@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private userController uss;

    @Autowired
    private  RepeatSubmitInterceptor repeatSubmitInterceptor;

    public void addInterceptors(InterceptorRegistry registry){

        //不拦截的url
        final String[] commonExclude = {"/user","/file/**"};

       // registry.addInterceptor((HandlerInterceptor) uss).excludePathPatterns(commonExclude);

        registry.addInterceptor(repeatSubmitInterceptor).excludePathPatterns(commonExclude);

    }


}
