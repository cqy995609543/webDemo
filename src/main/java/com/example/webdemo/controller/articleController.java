package com.example.webdemo.controller;


import com.example.webdemo.entity.ArticleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class articleController {

    @PostMapping("/addArticle")
        public String add(@Validated(value = ArticleDTO.AddArticleDTO.class) @RequestBody ArticleDTO articleDTO, BindingResult bindingResult) throws
            JsonProcessingException {

            //如果有错误信息提示信息
        if(bindingResult.hasErrors()){
            Map<String,String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach((item) -> {
                String message = item.getDefaultMessage();
                String filed = item.getField();
            });

            //  返回提示信息
            //ObjectMapper objectMapper;
            return "objectMapper.writeValueAsString(map)";
        }
        
        return "success";

    }




}
