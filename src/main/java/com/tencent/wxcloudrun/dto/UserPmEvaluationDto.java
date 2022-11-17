package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
    private Long id;

    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evaluationDate;

    private Integer[] skills;

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
