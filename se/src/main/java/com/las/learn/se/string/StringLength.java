package com.las.learn.se.string;

import org.junit.Test;

import java.nio.charset.Charset;

public class StringLength {

    String s1 = "a";
    String s2 = "国1a";
    String s3 = "aa";

    @Test
    public void testLength() {
        System.out.println(s1.getBytes(Charset.forName("unicode")).length);
        System.out.println(s2.getBytes(Charset.forName("unicode")).length);
        System.out.println(s3.getBytes(Charset.forName("unicode")).length);
        assert 1 == s1.getBytes().length;
        assert 3 == s2.length();
        assert 4 == s2.getBytes(Charset.forName("GBK")).length;
        assert 5 == s2.getBytes().length;
        assert 2 == s3.getBytes().length;
        assert 2 == s3.getBytes(Charset.forName("GBK")).length;
        assert 2 == s3.length();
    }
}
