package com.godling.springboot.core.jwt;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.json.JSONUtil;
import com.godling.springboot.common.utils.SpringUtils;
import com.godling.springboot.core.jwt.exception.JwtException;
import com.godling.springboot.core.jwt.exception.JwtExceptionEnum;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cai
 */
public class JwtUtils {

    private static final JwtProperties PROPERTIES = SpringUtils.getBean("jwtProperties");

    private static final String KEY_DATA = "data";

    private static String getSigningKey() {
        return SecureUtil.md5(PROPERTIES.getSecret());
    }

    private static String getRandomKey() {
        return RandomUtil.randomString(PROPERTIES.getRandomKeyLength());
    }

    private static String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + PROPERTIES.getExpire() * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, getSigningKey())
                .compact();
    }

    private static Claims getClaimFromToken(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody();
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌字符串
     * @return 是否过期
     */
    public static boolean isExpired(String token) {
        try {
            final Date expiration = getClaimFromToken(token).getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 生成令牌
     *
     * @param token 令牌对象
     * @return 令牌字符串
     */
    public static String generateToken(JwtToken token) {
        Map<String, Object> claims = new HashMap<>(2);
        String tokenJsonStr = JSONUtil.toJsonStr(token);
        claims.put(KEY_DATA, SecureUtil.rsa(PROPERTIES.getRsaPrivateKey(), PROPERTIES.getRsaPublicKey()).encryptHex(tokenJsonStr, KeyType.PrivateKey));
        claims.put(getRandomKey(), getRandomKey());
        return doGenerateToken(claims, String.valueOf(token.getId()));
    }

    /**
     * 解析令牌
     *
     * @param token 令牌字符串
     * @return 令牌对象
     */
    public static JwtToken analyseToken(String token) throws com.godling.springboot.core.jwt.exception.JwtException {
        try {
            Claims claims = getClaimFromToken(token);
            String encryptData = (String) claims.get(KEY_DATA);
            String decryptData = SecureUtil.rsa(PROPERTIES.getRsaPrivateKey(), PROPERTIES.getRsaPublicKey()).decryptStr(encryptData, KeyType.PublicKey);
            return JSONUtil.toBean(decryptData, JwtToken.class);
        } catch (Exception e) {
            throw new JwtException(JwtExceptionEnum.TOKEN_CRYPT_ERROR);
        }
    }

}
