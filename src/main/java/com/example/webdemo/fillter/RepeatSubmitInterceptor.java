package com.example.webdemo.fillter;

import com.example.webdemo.zhujie.RepeatSubmit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * 重复请求的拦截器
 * @Component：该注解将其注入到IOC容器中
 */


@Component
@Slf4j
public class RepeatSubmitInterceptor implements HandlerInterceptor {


    /**
     * Redis的API
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * preHandler方法，在controller方法之前执行
     *
     * 判断条件仅仅是用了uri，实际开发中根据实际情况组合一个唯一识别的条件。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)

    throws  Exception {

        if(handler instanceof HandlerMethod){

            //只拦截标注了@repeatSubmita该注解
            HandlerMethod method = (HandlerMethod) handler;

            //标注在方法上的@repeatSubmit
            RepeatSubmit repeatSubmitMethod =  AnnotationUtils.findAnnotation(method.getMethod(), RepeatSubmit.class);

            //标注在controler类上的@RepeatSubmit
            RepeatSubmit repeatSubmitClass = AnnotationUtils.findAnnotation(method.getMethod().getDeclaringClass(), RepeatSubmit.class);

            //没有限制重复提交，直接跳过
            if(Objects.isNull(repeatSubmitMethod) && Objects.isNull(repeatSubmitClass) ){
                return true;
            }

            // todo: 组合判断条件，这里仅仅是演示，实际项目中根据架构组合条件
            //请求的URI

            String url = request.getRequestURI();

            //存在即返回false，不存在即返回true
            Boolean isAbsent = stringRedisTemplate
                    .opsForValue()
                    .setIfAbsent(url,"",Objects.nonNull(repeatSubmitMethod)?repeatSubmitMethod.seconds():repeatSubmitClass.seconds(),
                            TimeUnit.SECONDS);
            //如果存在，表示已经请求过了，直接抛出异常，由全局异常进行处理返回指定信息
            if(isAbsent!=null && !isAbsent){
                throw new Exception("重复提交");
            }
        }
        System.out.println("进入拦截器");
        log.info("日志进入了拦截器");
        return  true;
    }

}
