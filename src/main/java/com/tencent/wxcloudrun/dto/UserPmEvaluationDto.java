package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
public class UserPmEvaluationDto {

    public UserPmEvaluationDto(UserPmEvaluationModel userPmEvaluationModel){
        if (null == userPmEvaluationModel) {
            return;
        }
        BeanUtils.copyProperties(userPmEvaluationModel, this);
    }

    private Long id;

    private String openId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evaluationDate;

    private String[] skills;

    private Integer studySkill;

    private Integer responsibility;

    private Integer communication;

    private Integer confidence;

    private Integer knowledgeStorage;

    private Integer pmSkill;

    private Integer operationSkill;

    private Integer dataAnalysis;

    private Integer officeSkill;

    private Integer pmoSkill;

    private Integer teamWork;

    private Integer promotionTraining;

    private Integer strategicThinking;

    private Integer businessThinking;

    private Integer decisionSkill;

    private Integer innovationSkill;
}
