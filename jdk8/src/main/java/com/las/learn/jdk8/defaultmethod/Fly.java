package com.las.learn.jdk8.defaultmethod;

/**
 * @author las
 */
public interface Fly {
    default void fly() {
        System.out.println("test fly");
    }
}
