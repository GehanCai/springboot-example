package com.godling.springboot.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 异常基类
 *
 * @author cai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    protected int code;
    /**
     * 错误消息
     */
    protected String message;

}
