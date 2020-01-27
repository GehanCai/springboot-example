package com.godling.springboot.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "请输入用户名")
    @Size(min = 5, max = 16, message = "用户名字符长度为6-16")
    private String username;

    @NotEmpty(message = "请输入密码")
    @Size(min = 6, max = 16, message = "密码字符长度为6-16")
    private String password;

    private Boolean rememberMe = false;

}
