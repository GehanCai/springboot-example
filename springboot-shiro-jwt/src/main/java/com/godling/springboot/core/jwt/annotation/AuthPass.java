package com.godling.springboot.core.jwt.annotation;

import java.lang.annotation.*;

/**
 * @author cai
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthPass {
}
