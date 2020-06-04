package cn.ideal.util;


import java.text.SimpleDateFormat;
import java.util.Date;
//日期与字符串转换工具类
public class DateUtils {
    //字符串转日期
    public static Date stringToDate(String dateStr) throws Exception {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    //日期转字符串
    public static String dateToString(Date date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }
}