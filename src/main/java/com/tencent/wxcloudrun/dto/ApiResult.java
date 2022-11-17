package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author: lsp
 * @Description
 * @Date 2022-07-01 15:37
 **/
@Data
@SuperBuilder
public class ApiResult<DATA> implements Serializable {
    private String code;
    private String description;
    private DATA data;

    public ApiResult() {
    }

    public ApiResult(@NonNull String code, @NonNull String description, DATA data) {
        if (code == null) {
            throw new NullPointerException("respCode is marked @NonNull but is null");
        } else if (description == null) {
            throw new NullPointerException("respMsg is marked @NonNull but is null");
        } else {
            this.code = code;
            this.description = description;
            this.data = data;
        }
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult(RespCode.SUCCESS.code, RespCode.SUCCESS.description, null);
    }

    public static <T> ApiResult<T> error() {
        return new ApiResult(RespCode.FAILED.code, RespCode.FAILED.description, null);
    }

    public static <T> ApiResult<T> error(String code, String description) {
        return new ApiResult(code, description, null);
    }

    public static <T> ApiResult<T> error(ErrorCodeEnum errorCodeEnum) {
        return new ApiResult(errorCodeEnum.getValue(), errorCodeEnum.getEnDesc(), Boolean.FALSE);
    }

    public static <T> ApiResult<T> error(ErrorCodeEnum errorCodeEnum, String msg) {
        return new ApiResult(errorCodeEnum.getValue(), msg, null);
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = success();
        result.setData(data);
        return result;
    }


    @AllArgsConstructor
    @Getter
    public enum RespCode {
        SUCCESS("200", "SUCCESS"),
        FAILED("-1", "FAILED");

        private String code;
        private String description;
    }
}
