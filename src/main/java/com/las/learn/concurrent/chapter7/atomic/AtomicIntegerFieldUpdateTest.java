package com.las.learn.concurrent.chapter7.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/12
 */
public class AtomicIntegerFieldUpdateTest {
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        User tom = new User("tom", 10);
        System.out.println(a.getAndIncrement(tom));
        System.out.println(tom);
        AtomicStampedReference<User> atomicStampedReference = new AtomicStampedReference<User>(tom, 1);
        int[] stamp=new int[1];
        System.out.println(atomicStampedReference.get(stamp));
        User jerry = new User("jerry", 19);
        atomicStampedReference.compareAndSet(tom, jerry, 1, 2);
        System.out.println(atomicStampedReference.get(stamp));
        atomicStampedReference.compareAndSet(jerry, tom, 2, 3);
        System.out.println(atomicStampedReference.get(stamp));
    }
}
