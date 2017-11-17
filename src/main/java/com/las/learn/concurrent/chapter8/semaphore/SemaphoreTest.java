package com.las.learn.concurrent.chapter8.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/14
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("save data,availablePermits: [" + s.availablePermits() + "],QueueLength:[" + s.getQueueLength() + "]");
                    s.release();
                }
            });
        }
        threadPool.shutdown();
    }
}
