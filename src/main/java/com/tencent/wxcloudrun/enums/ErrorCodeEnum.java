package com.tencent.wxcloudrun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    /**
     * Carry Over Error Code
     */
    ORDER_IS_NOT_EXIST("MOSC.PAY.0007", "order is not exist", "订单不存在"),
    ORDER_CAN_NOT_CANCEL("MOSC.PAY.0044", "order can not cancel", "订单状态不是待支付，不能取消"),
    ORDER_CAN_NOT_DELETE(" MOSC.PAY.0045", "order can not delete", "订单状态不是已关闭和已完成，不能删除"),

    /**
     * Internal Error Code
     */
    UNKNOWN_ERROR("000001", "UNKNOWN_ERROR", "未知错误"),

    PARAM_INVALID("000002", "PARAM_INVALID", "参数不合法"),

    PARAM_ABSENT("000003", "PARAM_ABSENT", "缺少必要参数"),

    HTTP_REQUEST_METHOD_INVALID("000004", "HTTP_REQUEST_METHOD_INVALID", "http请求方式不支持"),

    NOT_JSON_STRING("000005", "NOT_JSON_STRING", "入参必须是JSON格式"),

    CANCEL_ERROR("000006", "CANCEL_ERROR", "取消异常"),

    DELETE_ERROR("000007", "DELETE_ERROR", "删除异常"),

    ;

    private String value;
    private String enDesc;
    private String cnDesc;

}
