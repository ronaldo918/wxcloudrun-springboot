package com.tencent.wxcloudrun.advice;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tencent.wxcloudrun.dto.ApiResult;
import com.tencent.wxcloudrun.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


/**
 * @author vss913a
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    private static ApiResult<?> handle(Exception e, ErrorCodeEnum errorCodeEnum) {
        return handle(e, errorCodeEnum, errorCodeEnum.getEnDesc());
    }

    private static ApiResult<?> handle(Exception e, ErrorCodeEnum errorCodeEnum, String errMsg) {
        log.error(e.getMessage(), e);
        return ApiResult.error(errorCodeEnum, errMsg);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> bindException(BindException e) {
        if (StringUtils.isNotBlank(e.getMessage()) &&
                e.getMessage().contains("enum") &&
                e.getMessage().contains("ConversionFailedException")) {
            //判断是否为 枚举值传值不正确导致
            return handle(e, ErrorCodeEnum.PARAM_INVALID, e.getBindingResult().getFieldErrors().get(0).getField() + " is invalid.");
        }
        return handle(e, ErrorCodeEnum.PARAM_INVALID,
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> String.format("%s:%s", fieldError.getField(), fieldError.getDefaultMessage()))
                        .findFirst().orElse(ErrorCodeEnum.PARAM_INVALID.getEnDesc()));
    }

    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> conversionBindException(BindException e) {
        return handle(e, ErrorCodeEnum.PARAM_INVALID,
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> String.format("%s:%s", fieldError.getField(), fieldError.getDefaultMessage()))
                        .findFirst().orElse(ErrorCodeEnum.PARAM_INVALID.getEnDesc()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> constraintViolationException(ConstraintViolationException e) {
        return handle(e, ErrorCodeEnum.PARAM_INVALID, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> missingServletRequestParameterException(Exception e) {
        return handle(e, ErrorCodeEnum.PARAM_ABSENT, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return handle(e, ErrorCodeEnum.HTTP_REQUEST_METHOD_INVALID);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> methodArgumentNotValid(MethodArgumentNotValidException e) {
        return handle(e, ErrorCodeEnum.PARAM_INVALID,
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> String.format("%s:%s", fieldError.getField(), fieldError.getDefaultMessage()))
                        .findFirst().orElse(ErrorCodeEnum.PARAM_INVALID.getEnDesc()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<?> internalServerError(Exception ex) {
        if (null == ex.getCause()) {
            return handle(ex, ErrorCodeEnum.UNKNOWN_ERROR);
        }
        if (JsonParseException.class.isAssignableFrom(ex.getCause().getClass())) {
            log.error(ex.getMessage(), ex);
            return handle(ex, ErrorCodeEnum.NOT_JSON_STRING);
        }
        if (JsonMappingException.class.isAssignableFrom(ex.getCause().getClass())) {
            log.error(ex.getMessage(), ex);
            return handle(ex, ErrorCodeEnum.NOT_JSON_STRING);
        }
        return handle(ex, ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
