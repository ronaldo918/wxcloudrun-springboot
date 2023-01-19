package com.tencent.wxcloudrun.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.client.WechatClient;
import com.tencent.wxcloudrun.dao.UserPmEvaluationMapper;
import com.tencent.wxcloudrun.dto.ApiResult;
import com.tencent.wxcloudrun.dto.LoginDto;
import com.tencent.wxcloudrun.dto.UserPmEvaluationDto;
import com.tencent.wxcloudrun.external.GetLastResultReq;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import com.tencent.wxcloudrun.service.IUserPmEvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 16:49
 **/
@Slf4j
@Service
public class UserPmEvaluationImplService implements IUserPmEvaluationService {

    @Value("${app.id}")
    private String appId;

    @Value("${app.secret}")
    private String appSecret;

    @Value("${app.grantType}")
    private String grantType;

    @Resource
    private UserPmEvaluationMapper userPmEvaluationMapper;
    @Resource
    private WechatClient wechatClient;

    @Override
    public Boolean create(UserPmEvaluationDto userPmEvaluationDto) {
        UserPmEvaluationModel userPmEvaluationModel = new UserPmEvaluationModel();
        BeanUtils.copyProperties(userPmEvaluationDto, userPmEvaluationModel);
        Integer[] skills = userPmEvaluationDto.getSkills();
        userPmEvaluationModel.setStudySkill(skills[0]);
        userPmEvaluationModel.setResponsibility(skills[1]);
        userPmEvaluationModel.setCommunication(skills[2]);
        userPmEvaluationModel.setConfidence(skills[3]);
        userPmEvaluationModel.setKnowledgeStorage(skills[4]);
        userPmEvaluationModel.setPmSkill(skills[5]);
        userPmEvaluationModel.setOperationSkill(skills[6]);
        userPmEvaluationModel.setDataAnalysis(skills[7]);
        userPmEvaluationModel.setOfficeSkill(skills[8]);
        userPmEvaluationModel.setPmoSkill(skills[9]);
        userPmEvaluationModel.setTeamWork(skills[10]);
        userPmEvaluationModel.setPromotionTraining(skills[11]);
        userPmEvaluationModel.setStrategicThinking(skills[12]);
        userPmEvaluationModel.setBusinessThinking(skills[13]);
        userPmEvaluationModel.setDecisionSkill(skills[14]);
        userPmEvaluationModel.setInnovationSkill(skills[15]);
        return userPmEvaluationMapper.insert(userPmEvaluationModel) > 0;
    }

    @Override
    public UserPmEvaluationDto getLastResult(GetLastResultReq getLastResultReq) {
        UserPmEvaluationModel userPmEvaluationModel = userPmEvaluationMapper.selectLastOneByUserId(getLastResultReq.getUserId());
        UserPmEvaluationDto userPmEvaluationDto = new UserPmEvaluationDto();
        BeanUtils.copyProperties(userPmEvaluationModel, userPmEvaluationDto);
        return userPmEvaluationDto;
    }

    @Override
    public ApiResult<LoginDto> wechatLogin(String jsCode) {

        String result = wechatClient.jscode2session(appId, appSecret, jsCode, grantType);
        JSONObject jsonObject = JSON.parseObject(result);
        if (null == jsonObject || !jsonObject.get("errcode").equals(0)) {
            return ApiResult.error(jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
        }
        LoginDto loginDto = LoginDto.builder().openid(String.valueOf(jsonObject.get("openid")))
                .unionid(String.valueOf(jsonObject.get("unionid")))
                .sessionKey(String.valueOf(jsonObject.get("session_key")))
                .build();

        return ApiResult.success(loginDto);
    }

}
