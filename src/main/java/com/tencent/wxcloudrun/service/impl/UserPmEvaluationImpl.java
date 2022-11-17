package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.dao.UserPmEvaluationMapper;
import com.tencent.wxcloudrun.dto.UserPmEvaluationDto;
import com.tencent.wxcloudrun.external.GetLastResultReq;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import com.tencent.wxcloudrun.service.IUserPmEvaluation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 16:49
 **/
@Slf4j
@Service
public class UserPmEvaluationImpl implements IUserPmEvaluation {

    @Resource
    private UserPmEvaluationMapper userPmEvaluationMapper;

    @Override
    public Boolean create(UserPmEvaluationDto userPmEvaluationDto) {
        UserPmEvaluationModel userPmEvaluationModel = new UserPmEvaluationModel();
        BeanUtils.copyProperties(userPmEvaluationDto,userPmEvaluationModel);
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

}
