package com.las.learn.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda2 {

    @Test
    public void test1() {
        Runnable r = () -> System.out.print("hello lambda");
    }

    @Test
    public void test2() {
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

        consumer = x -> System.out.println(x);
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }
}
