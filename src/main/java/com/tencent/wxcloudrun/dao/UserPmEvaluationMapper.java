package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserPmEvaluationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPmEvaluationModel record);

    int insertSelective(UserPmEvaluationModel record);

    UserPmEvaluationModel selectByPrimaryKey(Long id);

    UserPmEvaluationModel selectLastOneByUserId(String userId);

    int updateByPrimaryKeySelective(UserPmEvaluationModel record);

    int updateByPrimaryKey(UserPmEvaluationModel record);
}