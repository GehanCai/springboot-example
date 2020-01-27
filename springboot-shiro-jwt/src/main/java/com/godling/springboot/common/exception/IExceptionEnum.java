package com.godling.springboot.common.exception;

/**
 * 异常枚举接口
 *
 * @author cai
 */
public interface IExceptionEnum {

    /**
     * 获取异常代码
     *
     * @return 异常代码
     */
    int getCode();

    /**
     * 获取异常信息
     *
     * @return 异常信息
     */
    String getMessage();

}
