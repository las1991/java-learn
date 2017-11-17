package com.las.learn.concurrent;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/11
 */
public class Shutdown {

    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //睡眠1秒，main线程对countThread进行中断，使countThread能够感知中断而结束
        SleepUtils.second(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        //睡眠1秒，main线程对countThread进行cancel，使countThread能够感知on为false而结束
        SleepUtils.second(1);
        two.cancel();
    }

    static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i=:" + i);
        }

        public void cancel() {
            this.on = false;
        }
    }
}
