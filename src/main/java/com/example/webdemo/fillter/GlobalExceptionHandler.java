package com.example.webdemo.fillter;


import com.example.webdemo.entity.ResultCodeEnum;
import com.example.webdemo.entity.ResultResponse;
import com.sun.corba.se.impl.io.TypeMismatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.net.BindException;

/**
 * 全局统一的异常处理，简单的配置下，根据自己的业务要求详细配置
 */



@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 重复请求的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultResponse onException(RuntimeException ex){
        //打印日志
        log.error(ex.getMessage());
        //todo 日志入库等操作
        //统一结果返回
        return new ResultResponse(ResultCodeEnum.CODE_NOT_REPEAT_SUBMIT);
    }


    /**
     * 自定义的业务上的异常
     */
    @ExceptionHandler(IOException.class)
    public ResultResponse onException(IOException exception){

        //打印日志
        log.error(exception.getMessage());

        return  new ResultResponse(ResultCodeEnum.CODE_SERVICE_FAIL);

    }

    /**
     * 捕获一些进入controller之前的异常，有些4xx的状态码统一设置为200
     注意：上面的只是一个例子，实际开发中还有许多的异常需要捕获，比如 TOKEN失效 、 过期 等等异常，
     如果整合了其他的框架，还要注意这些框架抛出的异常，比如 Shiro ， Spring Security 等等框架。
     异常匹配的顺序是什么？
     * @param ex
     * @return
     */

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class, MissingServletRequestParameterException.class,
            ServletRequestBindingException.class, ConversionNotSupportedException.class,
            TypeMismatchException.class, HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MissingServletRequestPartException.class, BindException.class,
            NoHandlerFoundException.class, AsyncRequestTimeoutException.class})
    public ResultResponse onException(Exception ex){
        //打印日志
        log.error(ex.getMessage());
        //todo 日志入库等等操作
        //统一结果返回
        return new ResultResponse(ResultCodeEnum.CODE_FAIL);
    }





}
