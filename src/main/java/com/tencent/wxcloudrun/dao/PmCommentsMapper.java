package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.PmCommentsModel;
import com.tencent.wxcloudrun.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PmCommentsMapper {

    int insert(PmCommentsModel record);

    List<PmCommentsModel> selectByOpenId(String openId);

    PmCommentsModel selectById(Long openId);

}