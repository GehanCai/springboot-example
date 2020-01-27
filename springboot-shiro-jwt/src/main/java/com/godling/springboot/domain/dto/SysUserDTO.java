package com.godling.springboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String salt;

    private List<String> roles;

    private List<String> perms;

}
