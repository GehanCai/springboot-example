package com.godling.springboot.common.base;


import com.godling.springboot.common.domain.RestResp;

/**
 * 控制器基类
 *
 * @author cai
 */
public class BaseController {

    /**
     * 返回成功
     */
    public RestResp success() {
        return RestResp.success();
    }

    public RestResp success(String message) {
        return RestResp.success(message);
    }

    public RestResp success(Object object) {
        return RestResp.success(object);
    }

    public RestResp success(String key, Object object) {
        return RestResp.success().append(key, object);
    }

    /**
     * 返回失败消息
     */
    public RestResp error() {
        return RestResp.error();
    }

    public RestResp error(String message) {
        return RestResp.error(message);
    }

    /**
     * 返回消息
     */
    public RestResp result(boolean status) {
        return status ? success() : error();
    }

    public RestResp result(boolean status, String message) {
        return status ? success() : error(message);
    }

}
