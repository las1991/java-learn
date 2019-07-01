package com.las.learn.geektime.jvm.jvmLoadClass;

/**
 * @author las
 * @date 19-7-1
 */
public class Singleton {
    private Singleton() {
    }

    private static class LazyHolder {
        static final Singleton SINGLETON = new Singleton();

        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    public static Object getInstance(boolean flag) {

        if (flag) return new LazyHolder[2];
        return LazyHolder.SINGLETON;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }
}
