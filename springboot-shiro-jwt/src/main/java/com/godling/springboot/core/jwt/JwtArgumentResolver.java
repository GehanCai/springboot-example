package com.godling.springboot.core.jwt;

import com.godling.springboot.core.jwt.annotation.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * @author cai
 */
@Slf4j
@Component
public class JwtArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private JwtProperties jwtProperties;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(AuthUser.class) && methodParameter.getParameterType().isAssignableFrom(JwtToken.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return nativeWebRequest.getAttribute(jwtProperties.getAuthAttr(), RequestAttributes.SCOPE_REQUEST);
    }


}
