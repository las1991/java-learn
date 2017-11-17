package com.las.learn.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/18
 */
public class FairAndUnfairTest {

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    private static CountDownLatch start = new CountDownLatch(1);

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        private CountDownLatch start;

        public Job(ReentrantLock2 lock, CountDownLatch start) {
            this.lock = lock;
            this.start = start;
        }

        public void run() {
            try{
                start.await();
            }catch (InterruptedException e) {
            }
            lock.lock();
            try {
                System.out.println("Lock by[" + currentThread().getName() + "],Waiting by " + lock.getQueuedThreads());
            } finally {
                lock.unlock();
            }
            lock.lock();
            try {
                System.out.println("Lock by[" + currentThread().getName() + "],Waiting by " + lock.getQueuedThreads());
            } finally {
                lock.unlock();
            }
        }
    }

    private static void testLock(ReentrantLock2 lock) {
        for (int i = 0; i < 5; i++) {
            Thread job = new Thread(new Job(lock, start), i + "");
            job.start();
        }
    }

    public static void main(String[] args) {
//        testLock(fairLock);

        testLock(unfairLock);
        start.countDown();
    }

}
