package com.las.learn.algorithm.question;

import org.junit.Test;

public class InterviewQuestion {

    @Test
    public void test0() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }

    @Test
    public void test1() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = ++j;
        }
        System.out.println(j);
    }
}
