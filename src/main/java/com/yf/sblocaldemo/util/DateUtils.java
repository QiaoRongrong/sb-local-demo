package com.yf.sblocaldemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

    public static final String ONLY_DATE = "yyyy-MM-dd";
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_NO_SENCOND = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FILE_NAME = "yyyyMMddHHmmss";
    public static final String DATE_CHINESE = "yyyy年MM月dd日";
    public static final String DATE_FORMAT = "yyyyMMdd";

    public static String getCurrent() {
        return getCurrent(DATE_TIME);
    }

    public static String getCurrent(String template) {
        Date date = new Date();
        return format(date, template);

    }

    public static String format(Date date, String template) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(template);
        return simpleDateFormat.format(date);
    }


}
