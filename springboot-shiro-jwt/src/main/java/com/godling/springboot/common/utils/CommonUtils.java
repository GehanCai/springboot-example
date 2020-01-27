package com.godling.springboot.common.utils;

import com.godling.springboot.common.exception.BusinessException;
import org.springframework.validation.BindingResult;

/**
 * @author cai
 */
public class CommonUtils {

    public static void validReq(BindingResult result) {
        if (result.getErrorCount() > 0) {
            String message = result.getFieldError() != null
                    ? result.getFieldError().getDefaultMessage()
                    : "请求参数异常";
            throw new BusinessException(4001, message);
        }
    }

}
