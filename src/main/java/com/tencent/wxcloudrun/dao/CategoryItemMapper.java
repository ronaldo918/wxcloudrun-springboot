package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.CategoryItemModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryItemMapper {

    int insert(CategoryItemModel record);

    List<CategoryItemModel> selectByResourceId(String resourceId);

    Integer getQuestionScore(String resourceId, String itemGrade);




}