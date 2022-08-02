package com.example.webdemo.entity;

public enum ResultCodeEnum {


        CODE_NOT_REPEAT_SUBMIT("重复提交异常"),
        CODE_SERVICE_FAIL("业务代码异常"),
        CODE_FAIL("200");

   // private String CODE_NOT_REPEAT_SUBMIT = 重复提交异常 ;


    private final String exeMsg;

    ResultCodeEnum(String exeMsg) {
        this.exeMsg = exeMsg;
    }
}
