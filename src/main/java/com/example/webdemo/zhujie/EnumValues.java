package com.example.webdemo.zhujie;


import com.example.webdemo.config.EnumValuesConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Constraint(validatedBy = { EnumValuesConstraintValidator.class })
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@NotNull(message = "不能为空")
public @interface EnumValues {

    /**
     * 提示消息
     */
    String message() default "传入的值不在范围内";

    /**
     * 分组
     * @return
     */
    Class<?>[] groups() default { };
    Class<? extends    Payload>[] payload() default { };
    /**
     * 可以传入的值
     * @return
     */
    int[] values() default { };


}
