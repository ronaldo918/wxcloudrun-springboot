package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserPmEvaluationMapper {

    int insert(UserPmEvaluationModel record);


    UserPmEvaluationModel selectLastOneByUserId(String openId);

    UserPmEvaluationModel selectFirstOneByUserId(String openId);

    List<UserPmEvaluationModel> selectByUserId(String openId);


    UserPmEvaluationModel selectById(Long id);


    Integer getCount();



}