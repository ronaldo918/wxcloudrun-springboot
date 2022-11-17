package com.tencent.wxcloudrun.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tencent.wxcloudrun.controller.SkillTestController;
import com.tencent.wxcloudrun.dto.PmCategoryDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: liushanping
 * @time: 2022/10/18 14:11
 */
@Slf4j
public class PmCategoryUtils {
    /**
     * douleMap缓存数据
     */
    public static Map<Integer, PmCategoryDto> doubleMap = new ConcurrentHashMap<>();
    public static List<PmCategoryDto> pmCategoryList = new ArrayList<PmCategoryDto>();

    /**
     * 映射关系，读取文件数据放到map中加载到缓存中
     */
    static {
        Map maps = JSON.parseObject(getFileString("/config/PmCategory.json"));

        log.info("PmCategoryUtils.static maps={}", JSON.toJSONString(maps));
        if (null != maps) {
            List<Object> list = JSON.parseObject(String.valueOf(maps.get("pmCategory")), List.class);
            for (Object object : list) {
                PmCategoryDto pmCategoryDto = readValue(JSON.toJSONString(object), PmCategoryDto.class);
                doubleMap.put(pmCategoryDto.getResourceId(), pmCategoryDto);
                pmCategoryList.add(pmCategoryDto);
            }
        }
    }

    public static List<PmCategoryDto> getPmCategoryDtoList() {
        return pmCategoryList;
    }


    public static PmCategoryDto getpmCategoryDto(Integer resourceId) {
        return doubleMap != null ? doubleMap.get(resourceId) : null;
    }


    /**
     * 读取文件流
     *
     * @param path
     * @return 字符串流
     */
    @SneakyThrows
    private static String getFileString(String path) {
        InputStream inputStream = SkillTestController.class.getResourceAsStream(path);

        int iAvail = inputStream.available();
        byte[] bytes = new byte[iAvail];
        inputStream.read(bytes);

        return new String(bytes);
    }

    @SneakyThrows({IOException.class})
    public static <T> T readValue(String src, Class<T> valueType) {
        //配置 被转的json字符串可以不用双引号引着  .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper.readValue(src, valueType);
    }

    public static void main(String[] args) {
        PmCategoryDto pmCategoryDto = PmCategoryUtils.getpmCategoryDto(3);
        System.out.println(JSON.toJSONString(pmCategoryDto));

    }
}
