package com.las.learn.se.time;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Date date = now.getTime();
        System.out.println(date.toLocaleString());
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        Date dateZero = now.getTime();
        System.out.println(dateZero.toLocaleString());

    }
}
