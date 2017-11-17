package com.las.learn.concurrent;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/14
 */
public class Profiler {

    //第一次get()方法调用时会进行初始化(如果set方法没有调用),每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {

        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("Cost:"
                + Profiler.end()
                + " minlls");
    }

}
