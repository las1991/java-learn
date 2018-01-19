package com.las.learn.se.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));

        Long fastTime = date.getTime() - date.getTime() % (30 * 60 * 1000);
        date.setTime(fastTime);
        System.out.println(format.format(date));
    }
}
