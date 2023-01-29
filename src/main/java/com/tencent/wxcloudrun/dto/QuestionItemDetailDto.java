package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tencent.wxcloudrun.model.CategoryItemModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @description:
 * @author: liushanping
 * @time: 2023/1/29 14:31
 */
@Data
@NoArgsConstructor
@SuperBuilder
@JsonSerialize
public class QuestionItemDetailDto {
    private String title;
    private String content;
    private Integer count;

    public QuestionItemDetailDto(CategoryItemModel categoryItemModel){
        title = categoryItemModel.getItemTitle();
        content = categoryItemModel.getItemContent();
        count = categoryItemModel.getItemCount();
    }
}
