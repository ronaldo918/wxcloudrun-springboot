package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tencent.wxcloudrun.model.PmCommentsModel;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
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
public class PmCommentsDto {

    public PmCommentsDto(PmCommentsModel pmCommentsModel){
        if (null == pmCommentsModel) {
            return;
        }
        BeanUtils.copyProperties(pmCommentsModel, this);
    }

    private Long id;

    private String openId;

    private String comments;

    private String contact;

    private Date createTime;

    private Date updateTime;

}
