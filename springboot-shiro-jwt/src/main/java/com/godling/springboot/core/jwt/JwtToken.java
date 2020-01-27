package com.godling.springboot.core.jwt;

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
public class JwtToken implements Serializable {

    private static final long serialVersionUID = -1333104829079408306L;

    private Long id;

}
