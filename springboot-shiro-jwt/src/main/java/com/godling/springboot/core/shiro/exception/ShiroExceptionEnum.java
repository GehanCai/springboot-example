package com.godling.springboot.core.shiro.exception;

import com.godling.springboot.common.exception.IExceptionEnum;
import lombok.Getter;

/**
 * @author cai
 */
@Getter
public enum ShiroExceptionEnum implements IExceptionEnum {

    /**
     * 异常枚举
     */
    USER_NOT_EXIST(1000, "用户不存在"),
    USER_ROLE_EMPTY(1000, "用户未设置角色"),
    ;

    private int code;

    private String message;

    ShiroExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
