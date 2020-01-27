package com.godling.springboot.common.exception;

import com.godling.springboot.common.domain.RestResp;
import com.godling.springboot.core.jwt.exception.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author cai
 */
@Slf4j
@Order(-1)
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public RestResp businessException(BusinessException e) {
        log.error("【业务异常】: {} - {}", e.getCode(), e.getMessage());
        return RestResp.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(JwtException.class)
    @ResponseBody
    public RestResp jwtException(JwtException e) {
        log.error("【令牌异常】: {} - {}", e.getCode(), e.getMessage());
        return RestResp.error(e.getCode(), e.getMessage());
    }

}
