package com.godling.springboot.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

}
