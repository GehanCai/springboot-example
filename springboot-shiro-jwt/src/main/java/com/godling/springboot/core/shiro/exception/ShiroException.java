package com.godling.springboot.core.shiro.exception;

import com.godling.springboot.common.base.BaseException;
import com.godling.springboot.common.exception.IExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ShiroException extends BaseException {

    public ShiroException(IExceptionEnum ee) {
        this.message = ee.getMessage();
        this.code = ee.getCode();
    }

}
