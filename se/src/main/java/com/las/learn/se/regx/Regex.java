package com.las.learn.se.regx;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    @Test
    public void testPattern() {
        String json = "{\"uuid\":\"3fb5e2c7142de21c\",\"os_type\":\"ios\",\"userExample\":\"las@sengled.com\",\"pwd\":\"123456\"}";
        String regex = "\"pwd\":\"(.*?)\"";// 使用非贪婪模式！
        Matcher matcher = Pattern.compile(regex).matcher(json);
        boolean find = matcher.find();
        if (find) {
            int group = 1;
            while (group <= matcher.groupCount()) {
                System.out.println(matcher.group(group));
                group++;
            }
        } else {
            System.out.println("not find");
        }
    }
}
