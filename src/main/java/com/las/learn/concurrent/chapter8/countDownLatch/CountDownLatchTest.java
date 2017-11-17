package com.las.learn.concurrent.chapter8.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/12
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("1 finish");
                c.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
                c.countDown();
            }
        }).start();
        c.await();
    }

}
