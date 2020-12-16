package com.las.learn.effective.i3Singleton;

/**
 * Singleton with static factory
 *
 * @author las
 */
public class Elvis2 {
    private static final Elvis2 INSTANCE = new Elvis2();

    private Elvis2() {
    }

    public static Elvis2 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }
}
