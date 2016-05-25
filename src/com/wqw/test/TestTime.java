package com.wqw.test;

public class TestTime {

    private static final int DAY = 24 * 60 * 60;
    private static final int HOUR = 60 * 60;
    private static final int MINUTE = 60;
    
    public static void main(String[] args) {
        
        String time = genTimeDescription(25*HOUR+20*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(24*HOUR+25*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(24*HOUR+38*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(29*HOUR+35*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(23*HOUR+20*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(50*MINUTE);
        System.out.println(time);
        
        time = genTimeDescription(0);
        System.out.println(time);
        
        updateLeftDistance(1530);
        updateLeftDistance(30);
        updateLeftDistance(8);
        updateLeftDistance(0);
    }
    
    public static void updateLeftDistance(float distance) {
        /* 单位转成公里 */
        float dis = distance / 10f;
        int round = Math.round(dis);
        dis = (float) round / 100;

        System.out.println(dis);
    }
    
    private static String genTimeDescription(int time) {
        StringBuilder sb = new StringBuilder();
        sb.append("还剩");
        if (time > DAY) {
            int day = time / DAY;
            sb.append(day);
            sb.append("天");

            time = time % DAY;

            int hour = (int) ((time + 0.5 * HOUR) / HOUR);
            sb.append(hour);
            sb.append("时");

        } else {

            if (time > HOUR) {
                int hour = time / HOUR;
                sb.append(hour);
                sb.append("时");

                time = time % HOUR;
            }

            int minute = time / MINUTE;
            sb.append(minute);
            sb.append("分");
        }

        return sb.toString();
    }
}
