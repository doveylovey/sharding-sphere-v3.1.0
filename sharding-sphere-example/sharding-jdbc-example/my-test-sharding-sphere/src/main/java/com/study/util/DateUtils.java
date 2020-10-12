package com.study.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 *
 * @author Administrator
 */
public class DateUtils {
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String YEAR_MONTH = "yyyy-MM";

    /**
     * 将 LocalDate 对象转成指定格式的字符串
     *
     * @param localDate 待转换 LocalDate 对象
     * @param pattern   目标日期格式
     * @return
     */
    public static String localDate2String(LocalDate localDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(formatter);
    }

    /**
     * 将 LocalDateTime 对象转成指定格式的字符串
     *
     * @param localDateTime 待转换 LocalDateTime 对象
     * @param pattern       目标日期格式
     * @return
     */
    public static String localDateTime2String(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 将字符串转成指定格式的 LocalDate 对象
     *
     * @param text    待转换字符串
     * @param pattern 目标日期格式
     * @return
     */
    public static LocalDate string2LocalDate(String text, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(text, formatter);
    }

    /**
     * 将字符串转成指定格式的 LocalDateTime 对象
     *
     * @param text    待转换字符串
     * @param pattern 目标日期时间格式
     * @return
     */
    public static LocalDateTime string2LocalDateTime(String text, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(text, formatter);
    }

    /**
     * 获取给定时间所在周的周一
     *
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getLocalDateTimeMonday(LocalDateTime localDateTime) {
        return localDateTime.with(DayOfWeek.MONDAY);
    }

    /**
     * 获取给定时间所在周的周日
     *
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getLocalDateTimeSunday(LocalDateTime localDateTime) {
        return localDateTime.with(DayOfWeek.SUNDAY);
    }

    public static LocalDate localDateTime2LocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    /*public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().minusDays(1);
        System.out.println("周一：" + DateUtils.getLocalDateTimeMonday(now));
        System.out.println("周日：" + DateUtils.getLocalDateTimeSunday(now));
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().minusDays(-10);
        System.out.println("目标表后缀范围：" + DateUtils.localDate2String(startDate, "yyyyMMdd") + " ~ " + DateUtils.localDate2String(endDate, "yyyyMMdd"));
    }*/
}
