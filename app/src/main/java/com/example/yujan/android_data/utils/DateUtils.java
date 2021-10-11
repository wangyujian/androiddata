package com.example.yujan.android_data.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by qilang on 2019/1/12
 * .
 */

public class DateUtils {
    /**
     * 由出生日期获得年龄
     *
     * @param strDate
     * @return
     * @throws Exception
     */
    public static int getAge(String strDate) throws Exception {
        return DateUtils.getAge(parse(strDate));
    }

    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }

    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * @param mss 要转换的秒数
     * @return 该秒数转换为 * days * hours * minutes 后的格式
     */
    public static String formatMapTime(long mss) {
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / (60);
        if (days == 0) {
            return hours + "时" + minutes + "分";
        } else {
            return days + "天" + hours + "时" + minutes + "分";
        }
    }

    /**
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return 输入的两个Date类型数据之间的时间间格用* days * hours * minutes 的格式展示
     */
    public static String formatDuring(Date begin, Date end) {
        return formatMapTime(end.getTime() - begin.getTime());
    }

    /**
     * 获取前一天的日期
     *
     * @return
     */
    public static Date getPreDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取当天的日期
     *
     * @return
     */
    public static Date getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /***
     * 日期月份减某个月
     *
     * @param datetime
     *            日期(2014-11)
     * @return 2014-10
     */
    public static String dateReduceMonth(String datetime, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(datetime);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.MONTH, -num);
            date = cl.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

    /***
     * 日期月份加某个月
     *
     * @param datetime
     *            日期(2014-11)
     * @return 2014-12
     */
    public static String dateAddMonth(String datetime, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(datetime);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.MONTH, +num);
            date = cl.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

    /**
     * 获取当前年月
     *
     * @return calendar
     */
    public static Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(new Date());
        return calendar;
    }

    /**
     * @param num 加的数，-num就是减去
     * @return 减去相应的数量的月份的日期
     */
    public static Calendar monthAddNum(Calendar calendar, Integer num) {
        calendar.add(Calendar.MONTH, num);// 加一个月
        return calendar;
    }

    /**
     * 日历转时间
     *
     * @return 202103
     */
    public static String calendarToDateStr(Calendar calendar) {
        int month = (calendar.get(Calendar.MONTH) + 1);
        if (month < 10) {
            return calendar.get(Calendar.YEAR) + "0" + (calendar.get(Calendar.MONTH) + 1);
        }
        return calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取之前（包含当前） num 个 年月日期
     *
     * @param num
     * @return
     */
    public static List<String> getPreviousYearMonth(int num) {
        List<String> list = new ArrayList<>();
        String time = "";
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < num; i++) {
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            if (month < 10) {
                time = year + "年0" + month + "月";
            } else {
                time = year + "年" + month + "月";
            }
            cal.add(Calendar.MONTH, -1);
            list.add(time);
        }
        return list;
    }

    /**
     * 获取之前（包含当前） 某个区间 年月日期
     *
     * @param list
     * @param start
     * @param end
     * @return
     */

    public static void getPreviousYearMonthByLimit(List<String> list, int start, int end) {
        String time = "";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -start);
        for (int i = start; i < end; i++) {
            time = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月";
            int month = cal.get(Calendar.MONTH) + 1;
            if (month < 10) {
                time = cal.get(Calendar.YEAR) + "0" + month;
            } else {
                time = cal.get(Calendar.YEAR) + "" + month;
            }
            cal.add(Calendar.MONTH, -1);
            list.add(time);
        }
    }

    /**
     * 获取之前（包含当前） num 个 年月日期 包含星期几
     *
     * @param num
     * @return
     */
    public static List<String> getNextYearMonth(int num) {
        List<String> list = new ArrayList<>();
        String monthStr = "";
        String dayStr = "";
        String weekStr = "";
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < num; i++) {
            //天
            int day = cal.get(Calendar.DATE);
            dayStr = day + "";
            if (day < 10) {
                dayStr = "0" + day;
            }

            //星期
            if (i == 0) {
                weekStr = "今日";
            } else {
                int week = cal.get(Calendar.DAY_OF_WEEK);
                /*星期日:Calendar.SUNDAY=1
                 *星期一:Calendar.MONDAY=2
                 *星期二:Calendar.TUESDAY=3
                 *星期三:Calendar.WEDNESDAY=4
                 *星期四:Calendar.THURSDAY=5
                 *星期五:Calendar.FRIDAY=6
                 *星期六:Calendar.SATURDAY=7 */
                switch (week) {
                    case 1:
                        weekStr = "周日";
                        break;
                    case 2:
                        weekStr = "周一";
                        break;
                    case 3:
                        weekStr = "周二";
                        break;
                    case 4:
                        weekStr = "周三";
                        break;
                    case 5:
                        weekStr = "周四";
                        break;
                    case 6:
                        weekStr = "周五";
                        break;
                    case 7:
                        weekStr = "周六";
                        break;
                    default:
                        break;
                }
            }
            //月份
            int month = cal.get(Calendar.MONTH) + 1;
            monthStr = String.valueOf(month);
            if (month < 10) {
                monthStr = "0" + month;
            }
            //日期加一天
            cal.add(Calendar.DATE, 1);
            list.add(monthStr + dayStr + weekStr);
        }
        return list;
    }
}
