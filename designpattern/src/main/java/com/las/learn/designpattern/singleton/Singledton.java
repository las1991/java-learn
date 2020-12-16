package com.las.learn.designpattern.singleton;

/**
 * @author las
 * @date 18-12-27
 */
public class Singledton {
    private static Singledton instance;

    public static Singledton getInstance() {
        if (null == instance) {
            instance = new Singledton();
        }
        return instance;
    }

    private Singledton() {
    }
}
