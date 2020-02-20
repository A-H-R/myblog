package com.mouse.util;
/*
 *created by mouse on 2020/2/20
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeString {
    public static String  getTime() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(new Date());
    }
}
