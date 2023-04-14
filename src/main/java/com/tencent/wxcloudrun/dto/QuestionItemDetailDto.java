package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tencent.wxcloudrun.model.CategoryItemModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

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
    private BigDecimal score;

    public QuestionItemDetailDto(CategoryItemModel categoryItemModel){
        title = categoryItemModel.getItemTitle();
        content = categoryItemModel.getItemContent();
        score = categoryItemModel.getScore();
    }
}
