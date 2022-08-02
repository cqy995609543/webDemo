package com.example.webdemo.fillter;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
public class CrosFilter implements Filter {


    //重写其中的doFilter方法

    public void doFilter(ServletRequest req , ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletResponse response =  (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers"," Origin, X-Requested-With, Content-Type,Accept");
        //继续执行下一个过滤器
        filterChain.doFilter(req,response);

    }


    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
