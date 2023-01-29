package com.tencent.wxcloudrun.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tencent.wxcloudrun.dao.CategoryItemMapper;
import com.tencent.wxcloudrun.dto.PmCategoryDto;
import com.tencent.wxcloudrun.dto.QuestionItemDetailDto;
import com.tencent.wxcloudrun.dto.QuestionItemDto;
import com.tencent.wxcloudrun.model.CategoryItemModel;
import com.tencent.wxcloudrun.service.ICategoryItemService;
import com.tencent.wxcloudrun.util.PmCategoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: liushanping
 * @time: 2023/1/29 14:00
 */
@Slf4j
@Service
public class CategoryItemServiceImpl implements ICategoryItemService {

    @Resource
    private CategoryItemMapper categoryItemMapper;


    @Override
    public List<CategoryItemModel> selectByResouceId(String resourceId) {
        List<CategoryItemModel> categoryItemModelList = categoryItemMapper.selectByResourceId(resourceId);
        return categoryItemModelList;
    }

    @Override
    public List<QuestionItemDto> listQuestion() {
        List<QuestionItemDto> questionItemDtoList = Lists.newArrayList();

        List<PmCategoryDto> pmCategoryDtoList = PmCategoryUtils.getPmCategoryDtoList();

        for(PmCategoryDto pmCategoryDto : pmCategoryDtoList) {

            List<CategoryItemModel> categoryItemModelList = categoryItemMapper.selectByResourceId(String.valueOf(pmCategoryDto.getResourceId()));
            if(null != categoryItemModelList) {
                QuestionItemDto questionItemDto = new QuestionItemDto();
                questionItemDto.setResourceId(pmCategoryDto.getResourceId().toString());
                questionItemDto.setId(pmCategoryDto.getResourceName());
                questionItemDto.setResourceName(pmCategoryDto.getResourceName());
                questionItemDto.setTitle(pmCategoryDto.getResourceDescription());
                questionItemDto.setType(1);
                Map<String, QuestionItemDetailDto> map = Maps.newHashMap();
                for (CategoryItemModel categoryItemModel : categoryItemModelList) {
                    map.put(categoryItemModel.getItemGrade(), new QuestionItemDetailDto(categoryItemModel));
                }
                questionItemDto.setData(map);

                questionItemDtoList.add(questionItemDto);
            }
        }
        return questionItemDtoList;
    }
}
