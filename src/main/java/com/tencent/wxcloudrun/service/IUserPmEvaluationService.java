package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.dto.*;
import com.tencent.wxcloudrun.external.*;

import java.util.List;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 16:47
 **/
public interface IUserPmEvaluationService {

    Long create(UserPmEvaluationDto userPmEvaluationDto);


    List<UserPmEvaluationDto> getEvaluationList(GetEvaluationListReq getEvaluationListReq);

    UserPmEvaluationDto detailUserPmEvaluation(Long id);

    UserPmEvaluationDto getLastResult(GetLastResultReq getLastResultReq);

    ApiResult<LoginDto> wechatLogin(String jsCode);


    ApiResult<String> addUser(UserDto userDto);


    Boolean userExisted(UserExistedReq userExistedReq);

    Boolean userEvaluated(UserEvaluatedReq userEvaluatedReq);

    Long addComments(PmCommentsReq pmCommentsReq);

    List<PmCommentsDto> getComments(PmGetCommentsReq pmGetCommentsReq);

    PmCommentsDto getCommentsDetail(PmGetCommentsDetailReq pmGetCommentsDetailReq);
}
