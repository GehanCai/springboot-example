package com.godling.springboot.controller;

import com.godling.springboot.common.base.BaseController;
import com.godling.springboot.common.domain.RestResp;
import com.godling.springboot.common.utils.CommonUtils;
import com.godling.springboot.core.jwt.JwtProperties;
import com.godling.springboot.core.jwt.JwtToken;
import com.godling.springboot.core.jwt.JwtUtils;
import com.godling.springboot.core.jwt.annotation.AuthPass;
import com.godling.springboot.core.jwt.annotation.AuthUser;
import com.godling.springboot.domain.req.LoginReq;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cai
 */
@RestController
@RequestMapping("")
//@RequiredArgsConstructor(onConstructor = @__(Autowired.class))
public class IndexController extends BaseController {

    @Resource
    private JwtProperties jwtProperties;

    @AuthPass
    @PostMapping("/login")
    public RestResp login(@Validated LoginReq req, BindingResult result) {
        CommonUtils.validReq(result);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(req);
        subject.login(new UsernamePasswordToken(req.getUsername(), req.getPassword()));
        String token = JwtUtils.generateToken(JwtToken.builder().id(1000L).build());
        return success().append("token", jwtProperties.getHeaderKey() + ":" + jwtProperties.getHeaderPrefix() + " " + token);

    }

    @PostMapping("/logout")
    public RestResp logout() {
        return success();
    }

    @PostMapping("/token/refresh")
    public RestResp tokenRefresh(@AuthUser JwtToken token) {
        return success().append("token", token);
    }

}
