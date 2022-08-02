package com.example.webdemo.config;


import com.example.webdemo.fillter.CrosFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Autowired
    private CrosFilter crosFilter;
/**
 * 注入crosFilter
 * @return
 */

    @Bean
    public FilterRegistrationBean crosFilter(){

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter((Filter) crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("crosFilter");
        //设置优先级别
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;



    }





}
