package com.godling.springboot.core.jwt.exception;

import com.godling.springboot.common.exception.IExceptionEnum;
import lombok.Getter;

/**
 * @author cai
 */
@Getter
public enum JwtExceptionEnum implements IExceptionEnum {

    /**
     * 异常枚举
     */
    TOKEN_CRYPT_ERROR(1001, "身份无效错误！"),
    TOKEN_ERROR(1001, "身份校验失败！"),
    TOKEN_EXPIRED(1002, "身份校验过期！"),
            ;

    private int code;

    private String message;

    JwtExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
