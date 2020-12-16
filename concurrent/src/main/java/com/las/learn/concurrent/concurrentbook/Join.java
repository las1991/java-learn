package com.las.learn.concurrent.concurrentbook;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/14
 */
public class Join {

    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        Thread pre = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(pre), String.valueOf(i));
            thread.start();
            pre = thread;
        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName()
                + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName()
                    + " terminate.");
        }
    }
}
