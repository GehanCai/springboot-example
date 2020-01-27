package com.godling.springboot.core.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author cai
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "app.jwt")
@EnableConfigurationProperties(value = {JwtProperties.class})
public class JwtProperties {

    private String[] authorisedUrls;

    private String secret = "secret";

    private Integer randomKeyLength = 6;

    private String rsaPrivateKey = "rsaPrivateKey";

    private String rsaPublicKey = "rsaPublicKey";

    private Long expire = 604800L;

    private String headerKey = "Authorization";

    private String headerPrefix = "Bearer ";

    private String authAttr = "token";

    //    private String md5Key = "randomKey";

}
