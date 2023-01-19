package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.ApiResult;
import com.tencent.wxcloudrun.dto.LoginDto;
import com.tencent.wxcloudrun.dto.PmCategoryDto;
import com.tencent.wxcloudrun.dto.UserPmEvaluationDto;
import com.tencent.wxcloudrun.external.FinishedNumReq;
import com.tencent.wxcloudrun.external.FinishedNumResp;
import com.tencent.wxcloudrun.external.GetLastResultReq;
import com.tencent.wxcloudrun.service.IUserPmEvaluationService;
import com.tencent.wxcloudrun.util.PmCategoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lsp
 * @Description
 * @Date 2022-05-25 17:54
 **/
@RestController
@Slf4j
@Validated
@RequestMapping(path = {"v1/skill/survey"})
public class SkillTestController {

    @Resource
    private IUserPmEvaluationService userPmEvaluationService;


    @PostMapping(value = "/finishedNum")
    public ApiResult<FinishedNumResp> getFinishedNumber(FinishedNumReq finishedNumReq){

        FinishedNumResp finishedNumResp = FinishedNumResp.builder().finishedNumber(50).build();
        return ApiResult.success(finishedNumResp);
    }

    @PostMapping(value = "/listPmCategory")
    public ApiResult<List<PmCategoryDto>> queryPmCategoryList(){
        return ApiResult.success(PmCategoryUtils.getPmCategoryDtoList());
    }


    @GetMapping(value = "/wechatLogin")
    public ApiResult<LoginDto> wechatLogin(@RequestParam String jsCode){
        return userPmEvaluationService.wechatLogin(jsCode);
    }

    @PostMapping(value = "/userPmEvaluationCreate")
    public ApiResult<Boolean> userPmEvaluationCreate(@RequestBody UserPmEvaluationDto userPmEvaluationDto){
        Boolean result = userPmEvaluationService.create(userPmEvaluationDto);
        return ApiResult.success(result);
    }

    @PostMapping(value = "/getLastResult")
    public ApiResult<UserPmEvaluationDto> getLastResult(@RequestBody GetLastResultReq getLastResultReq){
        UserPmEvaluationDto result = userPmEvaluationService.getLastResult(getLastResultReq);
        return ApiResult.success(result);
    }
}
