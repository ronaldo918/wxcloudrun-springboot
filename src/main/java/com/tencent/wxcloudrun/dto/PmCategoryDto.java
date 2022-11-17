package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/10/18 15:07
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class PmCategoryDto {
    private Integer resourceId;
    private String resourceName;
    private String resourceDescription;
}
