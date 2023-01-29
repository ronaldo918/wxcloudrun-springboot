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
public class CategoryItemModel {
    private Long id;

    private String resourceId;

    private String resourceName;

    private Integer resourceOrder;

    private String resourceType;

    private String itemGrade;

    private Integer itemGradeOrder;

    private String itemTitle;

    private String itemContent;

    private Integer itemCount;

    private Date createTime;

    private Date updateTime;

}