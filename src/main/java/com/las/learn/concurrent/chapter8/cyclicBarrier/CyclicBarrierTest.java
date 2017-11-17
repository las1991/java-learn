package com.las.learn.concurrent.chapter8.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/14
 */
public class CyclicBarrierTest {

    static CyclicBarrier c=new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
