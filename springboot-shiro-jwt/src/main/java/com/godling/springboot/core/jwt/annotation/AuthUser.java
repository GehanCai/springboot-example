package com.godling.springboot.core.jwt.annotation;

import java.lang.annotation.*;

/**
 * @author cai
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthUser {

    String value() default "token";

}
