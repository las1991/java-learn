package com.las.learn.concurrent.concurrentbook.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/7
 */
public class AtomicIntegerArrayTest {
    static int[] value=new int[]{1,2};

    static AtomicIntegerArray ai=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
