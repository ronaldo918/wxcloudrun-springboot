package com.tencent.wxcloudrun.util;

import com.google.common.collect.Maps;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    /**
     * token过期时间
     */
    private static long tokenExpiration = 365 * 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "123456";
    //加密密钥


    /**
     * 根据用户ID 和 用户名 生成token字符串
     *
     * @param map
     * @return
     */
    public static String createToken(Map<String, Object> map) {
        String token = StringUtils.EMPTY;

        JwtBuilder jwtBuilder = Jwts.builder()
                /**
                 * 主题
                 */
                .setSubject("AUTH-USER")
                /**
                 * //过期时间
                 */
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP);

        map.forEach((k, v) -> {
            jwtBuilder.claim(k, v);
        });
        token = jwtBuilder.compact();
        return token;
    }

    /**
     * 从token字符串获取userid
     *
     * @param token
     * @return
     */
    public static String getOpenId(String token) {
        try {
            if (StringUtils.isEmpty(token)) {
                return StringUtils.EMPTY;
            }
            /**
             * 用之前服务器写好的tokenSignKey进行验证解密
             */
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            /**
             * 得到有效载荷
             */
            Claims claims = claimsJws.getBody();
            String openId = String.valueOf(claims.get("openId"));
            return openId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void removeToken(String token) {
        //jwttoken无需删除，客户端扔掉即可，token一般由客户端放在请求头。
    }


    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        map.put("openId","diekdii-dkeidk-dddd");
        map.put("unionId","unionId-ddefa");
        String token = JwtUtils.createToken(map);
//"eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCjAK0A0Ndg1S0lFKrShQsjI0MzY2sDQ3MTbQUSotTi3yTFGyMjKEsP0Sc1OBWp6unfB0f7NSLQDxzD8_QwAAAA.2eCJdsJXOYaWFmPTJc8gl1YHTRl9DAeEJprKZn4IgJP9Fzo5fLddOQn1Iv2C25qMpwHQkPIGukTQtskWsNrnhQ";
        System.out.println(token);
        System.out.println(JwtUtils.getOpenId(token));


    }
}
