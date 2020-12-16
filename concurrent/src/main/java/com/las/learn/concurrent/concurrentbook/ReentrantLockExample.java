package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/7
 */
public class ReentrantLockExample {
    int a=0;
    ReentrantLock lock=new ReentrantLock();

    public void writer(){
        lock.lock();
        try{
            a++;
        }finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try{
            int i=a;
        }finally {
            lock.unlock();
        }
    }
}
