package com.godling.springboot.core.shiro;

import org.apache.shiro.util.ByteSource;

/**
 * @author cai
 */
public class ShiroUtils {

    public static ByteSource getSalt(String username, String salt) {
        return ByteSource.Util.bytes(username + ":" + salt);
    }

}
