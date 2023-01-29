package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.QuestionItemDto;
import com.tencent.wxcloudrun.model.CategoryItemModel;

import java.util.List;

/**
 * @description:
 * @author: liushanping
 * @time: 2023/1/29 13:59
 */
public interface ICategoryItemService {

    List<CategoryItemModel> selectByResouceId(String resourceId);

    List<QuestionItemDto> listQuestion();
}
