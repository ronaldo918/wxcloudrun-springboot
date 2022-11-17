package com.tencent.wxcloudrun.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: lsp
 * @Description
 * @Date 2022-07-15 15:46
 **/
public class DateUtils {
    private static String DATE_FORMAT = "yyyy-MM-dd";

    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static String DATE_FORMAT_STR = "yyyyMMddHHmmss";


    public static String parseDateTime(LocalDateTime localDateTime, String dateFormat) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return dateFormatter.format(localDateTime);
    }

}
