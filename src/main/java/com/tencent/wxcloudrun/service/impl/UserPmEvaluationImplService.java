package com.tencent.wxcloudrun.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tencent.wxcloudrun.client.WechatClient;
import com.tencent.wxcloudrun.dao.CategoryItemMapper;
import com.tencent.wxcloudrun.dao.PmCommentsMapper;
import com.tencent.wxcloudrun.dao.PmUserMapper;
import com.tencent.wxcloudrun.dao.UserPmEvaluationMapper;
import com.tencent.wxcloudrun.dto.*;
import com.tencent.wxcloudrun.enums.ErrorCodeEnum;
import com.tencent.wxcloudrun.external.*;
import com.tencent.wxcloudrun.model.PmCommentsModel;
import com.tencent.wxcloudrun.model.UserModel;
import com.tencent.wxcloudrun.model.UserPmEvaluationModel;
import com.tencent.wxcloudrun.service.IUserPmEvaluationService;
import com.tencent.wxcloudrun.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private CategoryItemMapper categoryItemMapper;
    @Resource
    private PmCommentsMapper pmCommentsMapper;
    @Resource
    private PmUserMapper pmUserMapper;
    @Resource
    private WechatClient wechatClient;

    @Override
    public Long create(UserPmEvaluationDto userPmEvaluationDto) {
        UserPmEvaluationModel userPmEvaluationModel = new UserPmEvaluationModel();
        BeanUtils.copyProperties(userPmEvaluationDto, userPmEvaluationModel);
        String[] skills = userPmEvaluationDto.getSkills();

        for (int i = 1; i <= 16; i++) {
            int index = i - 1;
            Integer score = categoryItemMapper.getQuestionScore(String.valueOf(i), skills[index]);
            if (null == score) {
                score = 0;
            }
            switch (i) {
                case 1:
                    userPmEvaluationModel.setStudySkill(score);
                    break;
                case 2:
                    userPmEvaluationModel.setResponsibility(score);
                    break;
                case 3:
                    userPmEvaluationModel.setCommunication(score);
                    break;
                case 4:
                    userPmEvaluationModel.setConfidence(score);
                    break;
                case 5:
                    userPmEvaluationModel.setKnowledgeStorage(score);
                    break;
                case 6:
                    userPmEvaluationModel.setPmSkill(score);
                    break;
                case 7:
                    userPmEvaluationModel.setOperationSkill(score);
                    break;
                case 8:
                    userPmEvaluationModel.setDataAnalysis(score);
                    break;
                case 9:
                    userPmEvaluationModel.setOfficeSkill(score);
                    break;
                case 10:
                    userPmEvaluationModel.setPmoSkill(score);
                    break;
                case 11:
                    userPmEvaluationModel.setTeamWork(score);
                    break;
                case 12:
                    userPmEvaluationModel.setPromotionTraining(score);
                    break;
                case 13:
                    userPmEvaluationModel.setStrategicThinking(score);
                    break;
                case 14:
                    userPmEvaluationModel.setBusinessThinking(score);
                    break;
                case 15:
                    userPmEvaluationModel.setDecisionSkill(score);
                    break;
                case 16:
                    userPmEvaluationModel.setInnovationSkill(score);
                    break;
                default:
                    break;
            }
        }
        Integer result = userPmEvaluationMapper.insert(userPmEvaluationModel);
        if (result > 0) {
            return userPmEvaluationModel.getId();
        } else {
            return 0L;
        }

    }

    @Override
    public List<UserPmEvaluationDto> getEvaluationList(GetEvaluationListReq getEvaluationListReq) {

        List<UserPmEvaluationModel> userPmEvaluationModelList = userPmEvaluationMapper.selectByUserId(getEvaluationListReq.getOpenId());
        if (CollectionUtils.isEmpty(userPmEvaluationModelList)) {
            return null;
        }
        List<UserPmEvaluationDto> userPmEvaluationDtoList = Lists.newArrayList();
        for (UserPmEvaluationModel userPmEvaluationModel : userPmEvaluationModelList) {
            userPmEvaluationDtoList.add(new UserPmEvaluationDto(userPmEvaluationModel));
        }
        return userPmEvaluationDtoList;
    }

    @Override
    public UserPmEvaluationDto detailUserPmEvaluation(Long id) {

        UserPmEvaluationModel userPmEvaluationModel = userPmEvaluationMapper.selectById(id);

        if (null == userPmEvaluationModel) {
            return null;
        }
        UserPmEvaluationDto userPmEvaluationDto = new UserPmEvaluationDto();
        BeanUtils.copyProperties(userPmEvaluationModel, userPmEvaluationDto);
        return userPmEvaluationDto;

    }

    @Override
    public UserPmEvaluationDto getLastResult(GetLastResultReq getLastResultReq) {
        UserPmEvaluationModel userPmEvaluationModel = userPmEvaluationMapper.selectLastOneByUserId(getLastResultReq.getOpenId());
        if (null == userPmEvaluationModel) {
            return null;
        }
        UserPmEvaluationDto userPmEvaluationDto = new UserPmEvaluationDto();
        BeanUtils.copyProperties(userPmEvaluationModel, userPmEvaluationDto);
        return userPmEvaluationDto;
    }

    @Override
    public ApiResult<LoginDto> wechatLogin(String jsCode) {
        try {
            String result = wechatClient.jscode2session(appId, appSecret, jsCode, grantType);
            log.info("UserPmEvaluationImplService,wechatLogin, result={}", result);
            JSONObject jsonObject = JSON.parseObject(result);
            if (null == jsonObject || (jsonObject.containsKey("errcode") && !jsonObject.get("errcode").equals(0))) {
                //return ApiResult.error(jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
                return ApiResult.error(ErrorCodeEnum.LOGIN_ERROR);
            }
            String unionid = String.valueOf(jsonObject.get("unionid"));
            String sessionKey = String.valueOf(jsonObject.get("session_key"));
            String openid = String.valueOf(jsonObject.get("openid"));

            Map map = Maps.newHashMap();
            map.put("unionid", unionid);
            map.put("openId", openid);
            String token = JwtUtils.createToken(map);
            LoginDto loginDto = LoginDto.builder().openid(openid).unionid(unionid).sessionKey(sessionKey).token(token).build();
            return ApiResult.success(loginDto);
        } catch (Exception ex) {
            log.error("UserPmEvaluationImplService,wechatLogin, ex", ex);
            return ApiResult.error(ErrorCodeEnum.LOGIN_ERROR);
        }

    }

    @Override
    public ApiResult<String> addUser(UserDto userDto) {
        try {
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(userDto, userModel);
            pmUserMapper.insert(userModel);
            return ApiResult.success(userDto.getOpenId());
        } catch (Exception ex) {
            log.error("UserPmEvaluationImplService,addUser, ex", ex);
            return ApiResult.error(ErrorCodeEnum.INSERT_USER_ERROR);
        }
    }

    @Override
    public Boolean userExisted(UserExistedReq userExistedReq) {

        UserModel userModel = pmUserMapper.selectOne(userExistedReq.getOpenId());
        if (null == userModel) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean userEvaluated(UserEvaluatedReq userEvaluatedReq) {
        UserPmEvaluationModel userPmEvaluationModel = userPmEvaluationMapper.selectLastOneByUserId(userEvaluatedReq.getOpenId());
        if (null == userPmEvaluationModel) {
            return false;
        }
        return true;
    }

    @Override
    public Long addComments(PmCommentsReq pmCommentsReq) {
        PmCommentsModel pmCommentsModel = new PmCommentsModel(pmCommentsReq);
        int result = pmCommentsMapper.insert(pmCommentsModel);
        if (result > 0) {
            return pmCommentsModel.getId();
        }
        return 0L;
    }

    @Override
    public List<PmCommentsDto> getComments(PmGetCommentsReq pmGetCommentsReq) {

        List<PmCommentsModel> pmCommentsModels = pmCommentsMapper.selectByOpenId(pmGetCommentsReq.getOpenId());


        if (CollectionUtils.isEmpty(pmCommentsModels)) {
            return null;
        }

        List<PmCommentsDto> pmCommentsDtos = Lists.newArrayList();

        for (PmCommentsModel pmCommentsModel : pmCommentsModels) {
            pmCommentsDtos.add(new PmCommentsDto(pmCommentsModel));
        }
        return pmCommentsDtos;
    }

    public PmCommentsDto getCommentsDetail(PmGetCommentsDetailReq pmGetCommentsDetailReq) {

        PmCommentsModel pmCommentsModel = pmCommentsMapper.selectById(pmGetCommentsDetailReq.getId());

        return new PmCommentsDto(pmCommentsModel);
    }
}
