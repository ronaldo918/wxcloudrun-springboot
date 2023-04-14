package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author vss913a
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class UserPmEvaluationModel {
    private Long id;

    private String openId;

    private Date evaluationDate;

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

    private Date createTime;

    private Date updateTime;

    private Integer ranking;

    private BigDecimal percent;

    private BigDecimal score;

    private String tencentGrade;

    private String aliGrade;

    private String byteGrade;

    private String meituanGrade;


}