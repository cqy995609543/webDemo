package com.example.webdemo.controller;


import com.example.webdemo.entity.User;
import com.example.webdemo.zhujie.RepeatSubmit;
import com.example.webdemo.zhujie.SwitchSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RepeatSubmit
public class userController {


    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id){

        User user = new User(1,"zhuzhu","15888888888");


        return  user;

    }

}
