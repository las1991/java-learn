package com.las.learn.concurrent.concurrentbook.threadPool;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author las
 * @date 19-7-25
 */
public class ThreadCpuTimeExample {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        threads[0] = new Thread(new MyTask("Task1", 50000), "Thread1");
        threads[1] = new Thread(new MyTask("Task2", 600000), "Thread2");
        threads[2] = new Thread(new MyTask("Task3", 900000), "Thread3");
        threads[0].setDaemon(true);
        threads[1].setDaemon(true);
        threads[2].setDaemon(true);
        threads[0].start();
        threads[1].start();
        threads[2].start();
        //sleep so that other threads catch up
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("Calculate Thread CPU Time");
        for (Thread thread : threads) {
            System.out.println(thread.getName() + "'s cpu time: " + cpuTime(thread));
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All threads finished their tasks");
    }

    private static long cpuTime(Thread thr) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        if (mxBean.isThreadCpuTimeSupported()) {
            try {
                return mxBean.getThreadCpuTime(thr.getId());
            } catch (UnsupportedOperationException e) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Not supported");
        }
        return 0;
    }
}
