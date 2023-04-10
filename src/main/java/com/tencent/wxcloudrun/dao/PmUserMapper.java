package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserModel;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PmUserMapper {

    int insert(UserModel record);

    UserModel selectOne(String openId);

}