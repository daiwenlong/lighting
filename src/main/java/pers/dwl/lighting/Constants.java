package pers.dwl.lighting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: lighting
 * @description: 常量类
 * @author: daiwenlong
 * @create: 2018-04-14 13:55
 **/
public class Constants {

    public static final String USER ="session_user";

    public static final String[] weekDays = {"周日","周一","周二","周三","周四","周五","周六"};

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy年MM月dd日");

    public static String getWeekOfDate(Date dt) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return FORMAT.format(dt)+" "+weekDays[w];
    }
}


