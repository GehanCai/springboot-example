package com.godling.springboot.core.jwt.exception;

import com.godling.springboot.common.base.BaseException;
import com.godling.springboot.common.exception.IExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class JwtException extends BaseException {

    public JwtException(IExceptionEnum ee) {
        this.message = ee.getMessage();
        this.code = ee.getCode();
    }
}
