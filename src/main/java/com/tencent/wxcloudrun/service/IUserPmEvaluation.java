package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.dto.UserPmEvaluationDto;
import com.tencent.wxcloudrun.external.GetLastResultReq;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 16:47
 **/
public interface IUserPmEvaluation {

    Boolean create(UserPmEvaluationDto userPmEvaluationDto);

    UserPmEvaluationDto getLastResult(GetLastResultReq getLastResultReq);
}
