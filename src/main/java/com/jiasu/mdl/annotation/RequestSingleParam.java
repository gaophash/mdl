package com.jiasu.mdl.annotation;

import java.lang.annotation.*;

/**
 *  
 *
 * @author Administrator
 * @Package com.jiasu.mdl.annotation
 * @Description:
 * @date 2023/1/10 14:59
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestSingleParam {

    String value();

    boolean required() default true;

    String defaultValue() default "";

}
