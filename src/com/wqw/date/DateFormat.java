package com.wqw.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

    private static String dataFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.CHINA);
        return sdf.format(new Date());
    }
    
    public static void main(String[] args) {
        System.out.println(dataFormat());
    }
}
