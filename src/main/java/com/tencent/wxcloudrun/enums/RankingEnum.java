package com.tencent.wxcloudrun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@Getter
public enum RankingEnum {


    RANKING_1(1, "赤足"),

    RANKING_2(2, "青铜1"),

    RANKING_3(3, "青铜2"),

    RANKING_4(4, "青铜3"),

    RANKING_5(5, "白银1"),

    RANKING_6(6, "白银2"),

    RANKING_7(7, "白银3"),

    RANKING_8(8, "黄金"),

    RANKING_9(9, "铂金"),

    RANKING_10(10, "钻石"),

    RANKING_11(11, "星耀"),

    RANKING_12(12, "最强王者"),

    RANKING_13(13, "无双王者"),

    RANKING_14(14, "荣耀王者"),

    RANKING_15(15, "传奇王者"),

    RANKING_16(16, "封神"),


    ;

    private Integer value;
    private String desc;


    public static String parseToDesc(Integer ranking) {

        for (RankingEnum v : RankingEnum.values()) {
            if (v.getValue().equals(ranking)) {
                return v.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }
}
