package com.las.learn.se.time;

import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) {
        System.out.println("user.timezone:" + System.getenv("user.timezone"));
        TimeZone zone = TimeZone.getDefault();
        System.out.println(zone);
        System.out.println("user.timezone:" + System.getenv("user.timezone"));

    }
}
