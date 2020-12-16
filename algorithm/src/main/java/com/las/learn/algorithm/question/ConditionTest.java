package com.las.learn.algorithm.question;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    final int[] count = {0};
    int sum = 30;


    @Test
    public void test() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (true) {
                        b.signal();
                        if (count[0] == sum) {
                            break;
                        }
                        System.out.print("a");
                        count[0]++;
                        a.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (true) {
                        c.signal();
                        if (count[0] == sum) {
                            break;
                        }
                        System.out.print("b");
                        count[0]++;
                        b.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (true) {
                        a.signal();
                        if (count[0] == sum) {
                            break;
                        }
                        System.out.print("c");
                        count[0]++;
                        c.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    public void test1() {
        Thread thread1 = new Thread(new ConditionTask(count, sum, "a", lock, a, b));
        Thread thread2 = new Thread(new ConditionTask(count, sum, "b", lock, b, c));
        Thread thread3 = new Thread(new ConditionTask(count, sum, "c", lock, c, a));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class ConditionTask implements Runnable {
        private int[] count;
        private int sum;
        private String str;
        private Lock lock;
        private Condition wait;
        private Condition signal;

        public ConditionTask(int[] count, int sum, String str, Lock lock, Condition wait, Condition signal) {
            this.count = count;
            this.sum = sum;
            this.str = str;
            this.lock = lock;
            this.wait = wait;
            this.signal = signal;
        }

        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis());
                lock.lock();
                wait.await();
                while (true) {
                    if (count[0] == sum) {
                        break;
                    }
                    System.out.print(str);
                    count[0]++;
                    wait.await();
                    signal.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
