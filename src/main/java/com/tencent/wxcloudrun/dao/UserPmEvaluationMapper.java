package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserPmEvaluationMapper {

    int insert(UserPmEvaluationModel record);


    UserPmEvaluationModel selectLastOneByUserId(String openId);


    UserPmEvaluationModel selectById(Long id);

}