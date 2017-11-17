package com.las.learn.concurrent.chapter8.countDownLatch;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/12
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser1 finish");
            }
        });
        final Thread parser2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser2 finish");
            }
        });

        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all pareser finish");
    }
}
