package com.freight.ms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wyq on 2018/4/14.
 */
public class DateUtil {
    public static String format(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
