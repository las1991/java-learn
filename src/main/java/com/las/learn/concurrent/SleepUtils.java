package com.las.learn.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/10
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
