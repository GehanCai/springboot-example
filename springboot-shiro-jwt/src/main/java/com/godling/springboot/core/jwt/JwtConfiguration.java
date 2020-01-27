package com.godling.springboot.core.jwt;

import com.godling.springboot.common.utils.SpringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cai
 */
@Configuration
public class JwtConfiguration implements WebMvcConfigurer {

    private JwtProperties properties = SpringUtils.getBean("jwtProperties");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径 可自行配置多个可用,分隔开
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns(properties.getAuthorisedUrls());
    }

}
