package com.example.webdemo.controller;

import com.example.webdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class helloWorld {
    //@RestController 标记一个controller ，是 @Controller 和
    //@ResponseBody  两个注解的集合
    //@RequestMapping 是一个映射注解，映射请求的URL
    //@ConfigurationProperties  注解能够很轻松的从配置文件中取值
    //@Value 这个注解估计很熟悉了，Spring中从属性取值的注解

    @RequestMapping("/hellworld")
    public String hiWorld(){
        log.info("info的日志");
        log.debug("DEBUG hello world 楼");
        return "hello world";
    }

    @GetMapping("/{ids}")
    public User getbyId(@PathVariable("ids") String ids){



        return  new User(1,"zhuzhu","13999999999");
    }





}
