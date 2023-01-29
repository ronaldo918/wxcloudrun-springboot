package com.tencent.wxcloudrun.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/10/19 16:40
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class GetLastResultReq {
    private String openId;
}
