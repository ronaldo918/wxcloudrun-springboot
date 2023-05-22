package com.tencent.wxcloudrun.enums;

import com.tencent.wxcloudrun.model.RankingGradeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum RankingEnum {


    RANKING_1(1, "赤足", "0", "0", "0", "0", new BigDecimal("0.01")),

    RANKING_2(2, "青铜1", "1-1", "P1", "1-1", "1-1", new BigDecimal("0.02")),

    RANKING_3(3, "青铜2", "1-2", "P2", "1-1", "1-2", new BigDecimal("0.04")),

    RANKING_4(4, "青铜3", "1-3", "P3", "1-2", "1-3", new BigDecimal("0.11")),

    RANKING_5(5, "白银1", "2-1", "P4", "1-2", "2-1", new BigDecimal("0.28")),

    RANKING_6(6, "白银2", "2-2", "P5", "2-1", "2-2", new BigDecimal("0.33")),

    RANKING_7(7, "白银3", "2-3", "P6", "2-1", "2-3", new BigDecimal("0.56")),

    RANKING_8(8, "黄金", "3-1", "P7", "2-2", "3-1", new BigDecimal("0.68")),

    RANKING_9(9, "铂金", "3-2", "P7", "3-1", "3-2", new BigDecimal("0.75")),

    RANKING_10(10, "钻石", "3-3", "P8", "3-2", "3-3", new BigDecimal("0.84")),

    RANKING_11(11, "星耀", "4-1", "P9", "3-2", "4-1", new BigDecimal("0.90")),

    RANKING_12(12, "最强王者", "4-2", "P10", "4-1", "4-2", new BigDecimal("0.92")),

    RANKING_13(13, "无双王者", "4-3", "P11", "4-2", "4-3", new BigDecimal("0.94")),

    RANKING_14(14, "荣耀王者", "5-1", "P12", "4-2", "5-1", new BigDecimal("0.96")),

    RANKING_15(15, "传奇王者", "5-2", "P13", "5-1", "5-2", new BigDecimal("0.99")),

    RANKING_16(16, "封神", "5-3", "P14", "5-2", "5-3", new BigDecimal("1.00")),


    ;

    private Integer value;
    private String desc;

    private String tencentGrade;

    private String aliGrade;

    private String byteGrade;

    private String meituanGrade;

    private BigDecimal percent;


    public static String parseToDesc(Integer ranking) {

        for (RankingEnum v : RankingEnum.values()) {
            if (v.getValue().equals(ranking)) {
                return v.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }


    public static BigDecimal parseToPercent(Integer ranking) {

        for (RankingEnum v : RankingEnum.values()) {
            if (v.getValue().equals(ranking)) {
                return v.getPercent();
            }
        }
        return new BigDecimal("0.20");
    }

    public static RankingGradeModel parseToRankingGradeModel(Integer ranking) {
        RankingGradeModel rankingGradeModel = new RankingGradeModel();
        for (RankingEnum v : RankingEnum.values()) {
            if (v.getValue().equals(ranking)) {
                rankingGradeModel.setTencentGrade(v.tencentGrade);
                rankingGradeModel.setMeituanGrade(v.meituanGrade);
                rankingGradeModel.setByteGrade(v.byteGrade);
                rankingGradeModel.setAliGrade(v.aliGrade);
                rankingGradeModel.setPercent(v.getPercent());
                return rankingGradeModel;
            }
        }
        return RankingGradeModel.builder().meituanGrade("2-2").aliGrade("P5").byteGrade("2-1").tencentGrade("2-2").percent(new BigDecimal(0.22)).build();
    }
}
