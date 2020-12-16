package com.las.learn.concurrent.concurrentbook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/4
 */
public class MutiThreadDemo {
    public static void main(String[] args) {
        MutiThread m=new MutiThread();
        List<Thread> threads=new ArrayList<Thread>();
        for(int i=0;i<3;i++){
            threads.add(new Thread(m,"thread "+i));
        }
        for (Thread t:threads){
            t.start();
        }
    }
}

class MutiThread implements Runnable {
    private AtomicInteger ticket = new AtomicInteger(100);//每个线程都拥有100张票

    public void run() {
        Integer i;
        while (( i=ticket.addAndGet(-1)) > 0) {
            System.out.println( i+ " is saled by " + Thread.currentThread().getName());
        }
    }
}
