package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/4/5
 */
public class BoundedQueue<T>{
    private Object[] items;
    private int addIndex,removeIndex,count;
    private Lock lock=new ReentrantLock();
    private Condition notEmpty=lock.newCondition();
    private Condition notFull=lock.newCondition();

    public BoundedQueue(int size) {
        this.items=new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            while (count==items.length)
            notFull.await();
            items[addIndex]=t;
            if (++addIndex==items.length)
                addIndex=0;
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        T t;
        try{
            while (count==0)
                notEmpty.await();
            t= (T) items[removeIndex];
            if(++removeIndex==items.length){
                removeIndex=0;
            }
            --count;
            notFull.signal();
        }finally {
            lock.unlock();
        }
        return t;
    }
}
