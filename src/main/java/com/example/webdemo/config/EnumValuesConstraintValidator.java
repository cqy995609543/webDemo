package com.example.webdemo.config;


import com.example.webdemo.zhujie.EnumValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 校验器
 */

public class EnumValuesConstraintValidator implements ConstraintValidator<EnumValues,Integer>{

    /**
     * 存储枚举的值
     */
    private Set<Integer> ints=new HashSet<>();

    /**
     * 初始化方法
     * @param enumValues 校验的注解
     */
    @Override
    public void initialize(EnumValues constraintAnnotation) {

        for (int value : constraintAnnotation.values()) {
            ints.add(value);
        }


        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     *
     * @param value 入参传的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        //判断是否包含这个值
        return ints.contains(integer);
    }
}
