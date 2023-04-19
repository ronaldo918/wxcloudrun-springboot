package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.*;
import com.tencent.wxcloudrun.enums.ErrorCodeEnum;
import com.tencent.wxcloudrun.external.*;
import com.tencent.wxcloudrun.model.CategoryItemModel;
import com.tencent.wxcloudrun.service.ICategoryItemService;
import com.tencent.wxcloudrun.service.IUserPmEvaluationService;
import com.tencent.wxcloudrun.util.PmCategoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private ICategoryItemService categoryItemService;


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
    public ApiResult<Long> userPmEvaluationCreate(@RequestBody UserPmEvaluationDto userPmEvaluationDto){
        Long result = userPmEvaluationService.create(userPmEvaluationDto);
        return ApiResult.success(result);
    }

    @PostMapping(value = "/getEvaluationList")
    public ApiResult<List<UserPmEvaluationDto>> getEvaluationList(@RequestBody GetEvaluationListReq getEvaluationListReq){
        List<UserPmEvaluationDto> result = userPmEvaluationService.getEvaluationList(getEvaluationListReq);
        if(null == result) {
            return ApiResult.success(null);
        }
        return ApiResult.success(result);
    }

    @PostMapping(value = "/detail")
    public ApiResult<UserPmEvaluationDto> userPmEvaluationDetail(@RequestParam Long id){
        UserPmEvaluationDto result = userPmEvaluationService.detailUserPmEvaluation(id);
        if(null == result) {
            return ApiResult.error(ErrorCodeEnum.USER_NO_RECORD);
        }
        return ApiResult.success(result);
    }

    @PostMapping(value = "/getLastResult")
    public ApiResult<UserPmEvaluationDto> getLastResult(@RequestBody GetLastResultReq getLastResultReq){
        UserPmEvaluationDto result = userPmEvaluationService.getLastResult(getLastResultReq);
        if(null == result) {
            return ApiResult.error(ErrorCodeEnum.USER_NO_RECORD);
        }
        return ApiResult.success(result);
    }

    @GetMapping(value = "/getCategoryItemList")
    public ApiResult<List<CategoryItemModel>> getCategoryItemList(@RequestParam String resourceId){
        List<CategoryItemModel> result = categoryItemService.selectByResouceId(resourceId);
        return ApiResult.success(result);
    }

    @PostMapping(value = "/listQuestion")
    public ApiResult<List<QuestionItemDto>> listQuestion(){
        List<QuestionItemDto> result = categoryItemService.listQuestion();
        return ApiResult.success(result);
    }

    @PostMapping(value = "/addUser")
    public ApiResult<String> addUser(@RequestBody UserDto userDto){
        String startWorkTime = userDto.getStartWorkTime() + "-01 00:00:00";
        String format = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sdf1 = new SimpleDateFormat(format);
        userDto.setStartWorkTime(startWorkTime);
        ApiResult<String> result = userPmEvaluationService.addUser(userDto);
        return result;
    }

    @PostMapping(value = "/userExisted")
    public ApiResult<Boolean> userExisted(@RequestBody UserExistedReq userExistedReq){
        Boolean result = userPmEvaluationService.userExisted(userExistedReq);
        return ApiResult.success(result);
    }

    @PostMapping(value = "/userEvaluated")
    public ApiResult<Boolean> userEvaluated(@RequestBody UserEvaluatedReq userEvaluatedReq){
        Boolean result = userPmEvaluationService.userEvaluated(userEvaluatedReq);
        return ApiResult.success(result);
    }


    @PostMapping(value = "/addComments")
    public ApiResult<Long> addComments(@RequestBody PmCommentsReq pmCommentsReq){
        Long result = userPmEvaluationService.addComments(pmCommentsReq);
        return ApiResult.success(result);
    }

    @PostMapping(value = "/listComments")
    public ApiResult<List<PmCommentsDto>> listComments(@RequestBody PmGetCommentsReq pmGetCommentsReq){
        List<PmCommentsDto> result = userPmEvaluationService.getComments(pmGetCommentsReq);
        return ApiResult.success(result);
    }


    @PostMapping(value = "/detailComments")
    public ApiResult<PmCommentsDto> detailComments(@RequestBody PmGetCommentsDetailReq pmGetCommentsDetailReq){
        PmCommentsDto result = userPmEvaluationService.getCommentsDetail(pmGetCommentsDetailReq);
        return ApiResult.success(result);
    }
}
