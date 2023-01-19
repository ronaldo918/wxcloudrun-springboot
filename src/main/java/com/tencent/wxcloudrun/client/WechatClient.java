package com.tencent.wxcloudrun.client;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.dto.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/11/11 13:52
 */
@Component
@FeignClient(value = "wechat", url = "${api.wechat.baseurl}")
public interface WechatClient {

    /**
     * 获取微信登录信息
     * @param appid
     * @param secret
     * @param js_code
     * @param grant_type
     * @return
     */
    @RequestMapping(value = "/sns/jscode2session", method = RequestMethod.GET)
    String jscode2session(@RequestParam String appid,
                       @RequestParam String secret,
                       @RequestParam String js_code,
                       @RequestParam String grant_type);




}
