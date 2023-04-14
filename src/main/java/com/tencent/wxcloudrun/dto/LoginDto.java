package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @description:
 * @author: liushanping
 * @time: 2023/1/19 17:40
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class LoginDto {
    private String openid;
    private String sessionKey;
    private String unionid;

    private String token;

}
