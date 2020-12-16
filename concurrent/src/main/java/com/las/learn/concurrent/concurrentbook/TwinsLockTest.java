package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.locks.Lock;
import org.junit.Test;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/18
 */
public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println("");
        }

    }


}
