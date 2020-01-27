package com.godling.springboot.common.domain;

import com.godling.springboot.common.exception.IExceptionEnum;
import lombok.Getter;
import org.springframework.core.Conventions;

import java.util.LinkedHashMap;

/**
 * Restful 响应
 *
 * @author cai
 */
public class RestResp extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";

    private LinkedHashMap<String, Object> data;

    private void code(int code) {
        super.put(CODE, code);
    }

    private void msg(String msg) {
        super.put(MSG, msg);
    }

    private RestResp() {
    }

    public RestResp setData(Object value) {
        super.put(DATA, value);
        return this;
    }

    public RestResp append(String key, Object value) {
        if (data == null) {
            data = new LinkedHashMap<>();
            super.put(DATA, data);
        }
        data.put(key, value);
        return this;
    }

    public RestResp append(Object value) {
        append(Conventions.getVariableName(value), value);
        return this;
    }

    @Getter
    enum ResultEnum implements IExceptionEnum {
        /**
         *
         */
        ERROR(1, "未知异常，请稍后重试！"),
        SUCCESS(0, "success");

        private int code;
        private String message;

        ResultEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    // 失败响应

    public static RestResp error(int code, String msg) {
        RestResp resp = new RestResp();
        resp.code(code);
        resp.msg(msg);
        return resp;
    }

    public static RestResp error(IExceptionEnum ee) {
        RestResp resp = new RestResp();
        resp.code(ee.getCode());
        resp.msg(ee.getMessage());
        return resp;
    }

    public static RestResp error(String msg) {
        return error(ResultEnum.ERROR.code, msg);
    }

    public static RestResp error() {
        return error(ResultEnum.ERROR);
    }

    // 成功响应

    /**
     * 成功响应
     *
     * @param ee 异常
     */
    public static RestResp success(IExceptionEnum ee) {
        RestResp resp = new RestResp();
        resp.code(ee.getCode());
        resp.msg(ee.getMessage());
        return resp;
    }

    public static RestResp success() {
        return RestResp.success(ResultEnum.SUCCESS);
    }

    public static RestResp success(String msg) {
        RestResp resp = new RestResp();
        resp.code(ResultEnum.ERROR.code);
        resp.msg(msg);
        return resp;
    }

    public static <T> RestResp success(T t) {
        return success().append(t);
    }

}
