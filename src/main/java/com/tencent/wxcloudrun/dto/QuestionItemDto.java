package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

/**
 * @description:
 * @author: liushanping
 * @time: 2023/1/28 13:30
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class QuestionItemDto {
    private String title;
    private String id;
    private String resourceId;
    private String resourceName;
    private Integer type;
    private Map data;
}
