package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/10/18 17:32
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class UserModel {
    private Long id;

    private String openId;

    private Integer productType;

    private Integer job;

    private Integer productDetail;

    private Integer industry;

    private String startWorkTime;

    private Integer ranking;

    private BigDecimal percent;

    private Date createTime;

    private Date updateTime;

}
