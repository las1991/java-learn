package com.las.learn.algorithm.question;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: liansheng
 * @Date: 2020/11/9 20:28
 * @Description:
 */
public class PrintABC implements Runnable {
    private static AtomicInteger count = new AtomicInteger(0);

    private static AtomicReference<String> semphore = new AtomicReference<>("A");
    private static Lock lock = new ReentrantLock();
    private static Condition print = lock.newCondition();

    public static boolean next() {
        boolean success = false;
        String s = semphore.get();
        if (Objects.equals(s, "A")) {
            success = semphore.compareAndSet(s, "B");
        } else if (Objects.equals(s, "B")) {
            success = semphore.compareAndSet(s, "C");
        } else if (Objects.equals(s, "C")) {
            success = semphore.compareAndSet(s, "A");
        }
        return success;
    }

    @Override
    public void run() {
        while (count.get() < 10) {
            String threadName = Thread.currentThread().getName();
            lock.lock();
            try {
                while (!Objects.equals(threadName, semphore.get())) {
                    print.await();
                }
                if (count.get() < 10) {
                    System.out.println(count + ":" + threadName);
                }
                while (!next()) ;
                count.getAndAdd(1);
                print.signalAll();
            } catch (InterruptedException e) {
                print.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        Thread a = new Thread(new PrintABC(), "A");
        Thread b = new Thread(new PrintABC(), "B");
        Thread c = new Thread(new PrintABC(), "C");
        a.start();
        b.start();
        c.start();

    }
}
