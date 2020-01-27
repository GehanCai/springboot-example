package com.godling.springboot.common.exception;

import com.godling.springboot.common.base.BaseException;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 *
 * @author cai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    private static final int ERROR_CODE = 1;

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(IExceptionEnum ee) {
        this.message = ee.getMessage();
        this.code = ee.getCode();
    }

    public BusinessException(String message) {
        this.code = ERROR_CODE;
        this.message = message;
    }

}
