package com.godling.springboot.core.jwt;

import com.godling.springboot.common.utils.SpringUtils;
import com.godling.springboot.common.utils.StringUtils;
import com.godling.springboot.core.jwt.annotation.AuthPass;
import com.godling.springboot.core.jwt.exception.JwtException;
import com.godling.springboot.core.jwt.exception.JwtExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cai
 */
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    private static final JwtProperties PROPERTIES = SpringUtils.getBean("jwtProperties");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;

            AuthPass pass = handlerMethod.getMethodAnnotation(AuthPass.class);

            if (pass != null) {
                return true;
            }
        }

        return requestHeaderHandle(request, response, handler);

    }

    private boolean requestHeaderHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        final String requestHeader = request.getHeader(PROPERTIES.getHeaderKey());

        if (StringUtils.isNotEmpty(requestHeader) && requestHeader.startsWith(PROPERTIES.getHeaderPrefix())) {

            String token = requestHeader.substring(PROPERTIES.getHeaderPrefix().length());

            if (JwtUtils.isExpired(token)) {
                throw new JwtException(JwtExceptionEnum.TOKEN_EXPIRED);
            }
            JwtToken jwtToken = JwtUtils.analyseToken(token);
            request.setAttribute(PROPERTIES.getAuthAttr(), jwtToken);
            return true;
        } else {
            throw new JwtException(JwtExceptionEnum.TOKEN_ERROR);
        }
    }

}
