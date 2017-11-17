package com.las.learn.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/1
 */
public class Counter {
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    private int i=0;

    public static void main(String[] args) {
        final Counter cas=new Counter();
        List<Thread> threads=new ArrayList<Thread>(600);

        Long start=System.currentTimeMillis();
        for (Integer j=0;j<100;j++){
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    for(int i=0;i<10000;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            threads.add(thread);
        }
        for (Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.print(System.currentTimeMillis()-start);
    }

    private void safeCount(){
        for (;;){
            int i=atomicInteger.get();
            boolean suc=atomicInteger.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }

    private void count(){
        i++;
    }

}
