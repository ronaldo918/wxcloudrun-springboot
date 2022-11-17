package com.tencent.wxcloudrun.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/5/10 14:39
 */
public interface BaseEnum<Value> {

    String METHOD_NAME = "getValue";

    /**
     * get the enum value
     * @return the enum value
     */
    @JsonValue
    Value getValue();

}
