package com.godling.springboot.common.utils;

import org.springframework.lang.Nullable;

/**
 * @author cai
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static boolean isNotEmpty(@Nullable Object str) {
        return !isEmpty(str);
    }

}
