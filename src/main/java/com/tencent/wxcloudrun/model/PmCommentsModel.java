package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tencent.wxcloudrun.dto.PmCommentsDto;
import com.tencent.wxcloudrun.external.PmCommentsReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

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
public class PmCommentsModel {

    public PmCommentsModel(PmCommentsDto pmCommentsDto){
        if (null == pmCommentsDto) {
            return;
        }
        BeanUtils.copyProperties(pmCommentsDto, this);
    }

    public PmCommentsModel(PmCommentsReq pmCommentsReq){
        if (null == pmCommentsReq) {
            return;
        }
        BeanUtils.copyProperties(pmCommentsReq, this);
    }

    private Long id;

    private String openId;

    private String comments;

    private String contact;
    private Date createTime;

    private Date updateTime;

}
