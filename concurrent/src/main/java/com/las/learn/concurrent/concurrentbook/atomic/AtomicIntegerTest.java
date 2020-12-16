package com.las.learn.concurrent.concurrentbook.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/7
 */
public class AtomicIntegerTest {

    static AtomicInteger ai=new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
