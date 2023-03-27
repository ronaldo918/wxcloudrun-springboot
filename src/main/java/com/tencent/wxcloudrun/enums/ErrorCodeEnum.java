package com.tencent.wxcloudrun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    /**
     * Internal Error Code
     */
    UNKNOWN_ERROR("000001", "UNKNOWN_ERROR", "未知错误"),

    PARAM_INVALID("000002", "PARAM_INVALID", "参数不合法"),

    PARAM_ABSENT("000003", "PARAM_ABSENT", "缺少必要参数"),

    HTTP_REQUEST_METHOD_INVALID("000004", "HTTP_REQUEST_METHOD_INVALID", "http请求方式不支持"),

    NOT_JSON_STRING("000005", "NOT_JSON_STRING", "入参必须是JSON格式"),

    LOGIN_ERROR("000006", "login error", "登录失败"),

    USER_NO_RECORD("000007", "user no record", "该用户没有测评记录"),

    ;

    private String value;
    private String enDesc;
    private String cnDesc;

}
