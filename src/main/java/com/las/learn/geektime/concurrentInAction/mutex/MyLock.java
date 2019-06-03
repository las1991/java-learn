package com.las.learn.geektime.concurrentInAction.mutex;

import java.util.concurrent.CountDownLatch;

/**
 * @author las
 * @date 19-6-3
 */
public class MyLock {

    // 测试转账的main方法
    public static void main(String[] args) throws InterruptedException {
        Account src = new Account(10000);
        Account target = new Account(10000);
        CountDownLatch countDownLatch = new CountDownLatch(9999);
        for (int i = 0; i < 9999; i++) {
            new Thread(() -> {
                src.transfer(target, 1);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("src=" + src.getBalance());
        System.out.println("target=" + target.getBalance());
    }
}
