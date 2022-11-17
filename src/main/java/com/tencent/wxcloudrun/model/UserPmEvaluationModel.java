package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

    private String userId;

    private Date evaluationDate;

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

    private Date createTime;

    private Date updateTime;

}