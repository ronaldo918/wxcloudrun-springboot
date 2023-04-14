package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

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

    private BigDecimal studySkill;

    private BigDecimal responsibility;

    private BigDecimal communication;

    private BigDecimal confidence;

    private BigDecimal knowledgeStorage;

    private BigDecimal pmSkill;

    private BigDecimal operationSkill;

    private BigDecimal dataAnalysis;

    private BigDecimal officeSkill;

    private BigDecimal pmoSkill;

    private BigDecimal teamWork;

    private BigDecimal promotionTraining;

    private BigDecimal strategicThinking;

    private BigDecimal businessThinking;

    private BigDecimal decisionSkill;

    private BigDecimal innovationSkill;

    private Integer ranking;

    private BigDecimal percent;

    private BigDecimal score;

    private String tencentGrade;

    private String aliGrade;

    private String byteGrade;

    private String meituanGrade;
}
