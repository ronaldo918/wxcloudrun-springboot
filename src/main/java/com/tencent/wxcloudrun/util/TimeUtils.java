package com.tencent.wxcloudrun.util;

/**
 * @author vss913a
 */
public class TimeUtils {
    String date;
    String[] dateArray;
    // 年份
    int year;
    // 月份
    int month;
    // 日期
    int day;
    // 总天数
    int allDay = 365;

    public TimeUtils(String date) {
        this.date = date;
        this.dateArray = date.trim().split("-");
        this.year = Integer.parseInt(dateArray[0]);
        this.month = Integer.parseInt(dateArray[1]);
        this.day = Integer.parseInt(dateArray[2]);
    }

    // 输入指定日期，返回已经过去了多少天
    public int elapsedTime() {
        // 计算经历过的天数
        int elapsedTime = day;
        for (int i = 1; i < this.month; i++) {
            elapsedTime = elapsedTime + month(this.year, i);
        }
        return elapsedTime;
    }

    // 输入指定日期，返回还剩多少天
    public int daysLeft() {
        // 计算剩下的天数
        int daysLeft = allDay - elapsedTime();
        return daysLeft;
    }


    public int daysYear() {
        // 计算剩下的天数
        if (year(this.year)) {
            return 366;
        }
        return 365;
    }


    // 判断输入的日期，是否符合格式要求
    public boolean format() {
        boolean judge = true;
        if ((date.length() != 10) && (date.charAt(4) != '-') && (date.charAt(7) != '-')) {
            System.out.println("您输入的日期有误");
            judge = false;
        }
        return judge;
    }

    // 判断是闰年还是平年
    public boolean year(int year) {
        boolean judge = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            allDay = 366;
            judge = true;
        }
        return judge;
    }


    // 输入月份返回共有多少天
    public int month(int year, int month) {
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if (year(year)) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;
        }
        return day;
    }

    // 计算在输入的月份里还剩多少天
    public int day(int year, int month, int day) {
        int daysLeft = month(year, month) - day;
        return daysLeft;
    }

    public String toString() {
        String time = null;
        if (month >= 6) {
            time = year + "年已过去了" + elapsedTime() + "天，还剩下" + daysLeft() + "天，在剩下的日子里，你要继续加油哦！";
        } else {
            time = year + "年已过去了" + elapsedTime() + "天，还剩下" + daysLeft() + "天，新的一年才刚刚开始，你要加油哦！";
        }
        return time;
    }
}
