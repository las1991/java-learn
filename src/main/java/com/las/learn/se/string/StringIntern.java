package com.las.learn.se.string;

import org.junit.Test;

/**
 * @author las
 * @date 19-7-25
 */
public class StringIntern {

    @Test
    public void test() {
        String s0 = new StringBuilder("go")
                .append("od").toString();
        String s1 = s0.intern();
        System.out.println(s1 == s0);

        String s2 = new StringBuilder("ja")
                .append("va").toString();
        String s2_ = "java";
        String s3 = s2.intern();
        System.out.println(s3 == s2);
        System.out.println(s3 == s2_);

        String s4 = new StringBuilder("co")
                .append("ok").toString();
        String s5 = s4.intern();
        System.out.println(s5 == s4);


    }
}
