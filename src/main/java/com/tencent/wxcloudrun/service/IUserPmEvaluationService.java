package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.dto.ApiResult;
import com.tencent.wxcloudrun.dto.LoginDto;
import com.tencent.wxcloudrun.dto.UserDto;
import com.tencent.wxcloudrun.dto.UserPmEvaluationDto;
import com.tencent.wxcloudrun.external.GetLastResultReq;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 16:47
 **/
public interface IUserPmEvaluationService {

    Boolean create(UserPmEvaluationDto userPmEvaluationDto);


    UserPmEvaluationDto detailUserPmEvaluation(Long id);

    UserPmEvaluationDto getLastResult(GetLastResultReq getLastResultReq);

    ApiResult<LoginDto> wechatLogin(String jsCode);


    ApiResult<String> addUser(UserDto userDto);
}
