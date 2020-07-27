package com.shunteng.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 映射方法顺序执行注解
 * @Author GCL
 * @Date 2020/7/2 下午3:17
 */
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodOrder {

    int value() default 0;
}
