package com.tencent.wxcloudrun.util;

import com.tencent.wxcloudrun.enums.RankingEnum;
import com.tencent.wxcloudrun.model.RankingGradeModel;

import java.math.BigDecimal;

public class RankingUtils {

    public static RankingGradeModel getRankingGrade(BigDecimal score) {
        RankingGradeModel rankingGradeModel = new RankingGradeModel();
        if (score.compareTo(BigDecimal.ZERO) > -1
                && score.compareTo(new BigDecimal(6)) == -1) {
            rankingGradeModel.setTencentGrade("0");
            rankingGradeModel.setAliGrade("0");
            rankingGradeModel.setByteGrade("0");
            rankingGradeModel.setMeituanGrade("0");
            rankingGradeModel.setRanking(RankingEnum.RANKING_1.getValue());
        } else if (score.compareTo(new BigDecimal(6)) > -1
                && score.compareTo(new BigDecimal(15)) == -1) {
            rankingGradeModel.setTencentGrade("1-1");
            rankingGradeModel.setAliGrade("P1");
            rankingGradeModel.setByteGrade("1-1");
            rankingGradeModel.setMeituanGrade("1-1");
            rankingGradeModel.setRanking(RankingEnum.RANKING_2.getValue());
        } else if (score.compareTo(new BigDecimal(15)) > -1
                && score.compareTo(new BigDecimal(20)) == -1) {
            rankingGradeModel.setTencentGrade("1-2");
            rankingGradeModel.setAliGrade("P2");
            rankingGradeModel.setByteGrade("1-1");
            rankingGradeModel.setMeituanGrade("1-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_3.getValue());
        } else if (score.compareTo(new BigDecimal(20)) > -1
                && score.compareTo(new BigDecimal(28)) == -1) {
            rankingGradeModel.setTencentGrade("1-3");
            rankingGradeModel.setAliGrade("P3");
            rankingGradeModel.setByteGrade("1-2");
            rankingGradeModel.setMeituanGrade("1-3");
            rankingGradeModel.setRanking(RankingEnum.RANKING_4.getValue());
        } else if (score.compareTo(new BigDecimal(28)) > -1
                && score.compareTo(new BigDecimal(33.5)) == -1) {
            rankingGradeModel.setTencentGrade("2-1");
            rankingGradeModel.setAliGrade("P4");
            rankingGradeModel.setByteGrade("1-2");
            rankingGradeModel.setMeituanGrade("2-1");
            rankingGradeModel.setRanking(RankingEnum.RANKING_5.getValue());
        } else if (score.compareTo(new BigDecimal(33.5)) > -1
                && score.compareTo(new BigDecimal(36.5)) == -1) {
            rankingGradeModel.setTencentGrade("2-2");
            rankingGradeModel.setAliGrade("P5");
            rankingGradeModel.setByteGrade("2-1");
            rankingGradeModel.setMeituanGrade("2-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_6.getValue());
        } else if (score.compareTo(new BigDecimal(36.5)) > -1
                && score.compareTo(new BigDecimal(45)) == -1) {
            rankingGradeModel.setTencentGrade("2-3");
            rankingGradeModel.setAliGrade("P6");
            rankingGradeModel.setByteGrade("2-1");
            rankingGradeModel.setMeituanGrade("2-3");
            rankingGradeModel.setRanking(RankingEnum.RANKING_7.getValue());
        } else if (score.compareTo(new BigDecimal(45)) > -1
                && score.compareTo(new BigDecimal(50)) == -1) {
            rankingGradeModel.setTencentGrade("3-1");
            rankingGradeModel.setAliGrade("P7");
            rankingGradeModel.setByteGrade("2-2");
            rankingGradeModel.setMeituanGrade("3-1");
            rankingGradeModel.setRanking(RankingEnum.RANKING_8.getValue());
        } else if (score.compareTo(new BigDecimal(50)) > -1
                && score.compareTo(new BigDecimal(53.5)) == -1) {
            rankingGradeModel.setTencentGrade("3-2");
            rankingGradeModel.setAliGrade("P7");
            rankingGradeModel.setByteGrade("3-1");
            rankingGradeModel.setMeituanGrade("3-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_9.getValue());
        } else if (score.compareTo(new BigDecimal(53.5)) > -1
                && score.compareTo(new BigDecimal(60.5)) == -1) {
            rankingGradeModel.setTencentGrade("3-3");
            rankingGradeModel.setAliGrade("P8");
            rankingGradeModel.setByteGrade("3-2");
            rankingGradeModel.setMeituanGrade("3-3");
            rankingGradeModel.setRanking(RankingEnum.RANKING_10.getValue());
        } else if (score.compareTo(new BigDecimal(60.5)) > -1
                && score.compareTo(new BigDecimal(63)) == -1) {
            rankingGradeModel.setTencentGrade("4-1");
            rankingGradeModel.setAliGrade("P9");
            rankingGradeModel.setByteGrade("3-2");
            rankingGradeModel.setMeituanGrade("4-1");
            rankingGradeModel.setRanking(RankingEnum.RANKING_11.getValue());
        } else if (score.compareTo(new BigDecimal(63)) > -1
                && score.compareTo(new BigDecimal(67.5)) == -1) {
            rankingGradeModel.setTencentGrade("4-2");
            rankingGradeModel.setAliGrade("P10");
            rankingGradeModel.setByteGrade("4-1");
            rankingGradeModel.setMeituanGrade("4-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_12.getValue());
        } else if (score.compareTo(new BigDecimal(67.5)) > -1
                && score.compareTo(new BigDecimal(70)) == -1) {
            rankingGradeModel.setTencentGrade("4-3");
            rankingGradeModel.setAliGrade("P11");
            rankingGradeModel.setByteGrade("4-2");
            rankingGradeModel.setMeituanGrade("4-3");
            rankingGradeModel.setRanking(RankingEnum.RANKING_13.getValue());
        } else if (score.compareTo(new BigDecimal(70)) > -1
                && score.compareTo(new BigDecimal(74)) == -1) {
            rankingGradeModel.setTencentGrade("5-1");
            rankingGradeModel.setAliGrade("P12");
            rankingGradeModel.setByteGrade("4-2");
            rankingGradeModel.setMeituanGrade("5-1");
            rankingGradeModel.setRanking(RankingEnum.RANKING_14.getValue());
        } else if (score.compareTo(new BigDecimal(74)) > -1
                && score.compareTo(new BigDecimal(77)) < 1) {
            rankingGradeModel.setTencentGrade("5-2");
            rankingGradeModel.setAliGrade("P13");
            rankingGradeModel.setByteGrade("5-1");
            rankingGradeModel.setMeituanGrade("5-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_15.getValue());
        } else if (score.compareTo(new BigDecimal(77)) > -1) {
            rankingGradeModel.setTencentGrade("5-3");
            rankingGradeModel.setAliGrade("P14");
            rankingGradeModel.setByteGrade("5-2");
            rankingGradeModel.setMeituanGrade("5-3");
            rankingGradeModel.setRanking(RankingEnum.RANKING_16.getValue());
        } else {
            rankingGradeModel.setTencentGrade("3-2");
            rankingGradeModel.setAliGrade("P7");
            rankingGradeModel.setByteGrade("3-1");
            rankingGradeModel.setMeituanGrade("3-2");
            rankingGradeModel.setRanking(RankingEnum.RANKING_9.getValue());
        }

        return rankingGradeModel;
    }

    public static Integer getRanking(BigDecimal score) {
        RankingGradeModel rankingGradeModel = new RankingGradeModel();
        if (score.compareTo(BigDecimal.ZERO) == 0) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_1.getValue());
        } else if (score.compareTo(BigDecimal.ZERO) > -1
                && score.compareTo(new BigDecimal(6)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_2.getValue());
        } else if (score.compareTo(new BigDecimal(6)) > -1
                && score.compareTo(new BigDecimal(15)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_3.getValue());
        } else if (score.compareTo(new BigDecimal(15)) > -1
                && score.compareTo(new BigDecimal(20)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_4.getValue());
        } else if (score.compareTo(new BigDecimal(20)) > -1
                && score.compareTo(new BigDecimal(28)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_5.getValue());
        } else if (score.compareTo(new BigDecimal(28)) > -1
                && score.compareTo(new BigDecimal(33.5)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_6.getValue());
        } else if (score.compareTo(new BigDecimal(33.5)) > -1
                && score.compareTo(new BigDecimal(36.5)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_7.getValue());
        } else if (score.compareTo(new BigDecimal(36.5)) > -1
                && score.compareTo(new BigDecimal(45)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_8.getValue());
        } else if (score.compareTo(new BigDecimal(45)) > -1
                && score.compareTo(new BigDecimal(50)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_9.getValue());
        } else if (score.compareTo(new BigDecimal(50)) > -1
                && score.compareTo(new BigDecimal(53.5)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_10.getValue());
        } else if (score.compareTo(new BigDecimal(53.5)) > -1
                && score.compareTo(new BigDecimal(61)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_11.getValue());
        } else if (score.compareTo(new BigDecimal(61)) > -1
                && score.compareTo(new BigDecimal(63)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_12.getValue());
        } else if (score.compareTo(new BigDecimal(63)) > -1
                && score.compareTo(new BigDecimal(68)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_13.getValue());
        } else if (score.compareTo(new BigDecimal(68)) > -1
                && score.compareTo(new BigDecimal(71)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_14.getValue());
        } else if (score.compareTo(new BigDecimal(71)) > -1
                && score.compareTo(new BigDecimal(74)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_15.getValue());
        } else if (score.compareTo(new BigDecimal(74)) > -1
                && score.compareTo(new BigDecimal(77)) == -1) {
            rankingGradeModel.setRanking(RankingEnum.RANKING_16.getValue());
        } else {
            rankingGradeModel.setRanking(RankingEnum.RANKING_9.getValue());
        }
        return rankingGradeModel.getRanking();
    }

}
