package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class RankingGradeModel {

    private Integer ranking;

    private String tencentGrade;

    private String aliGrade;

    private String meituanGrade;

    private String byteGrade;

    private BigDecimal percent;



}
