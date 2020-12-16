package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by las on 2016/3/17.
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {
        /**
         * 静态内部类，自定义同步器
         *
         * @return
         */
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 当状态为0的时候获取锁
         *
         * @param acquires
         * @return
         */
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁，将状态置为0
         *
         * @param release
         * @return
         */
        protected boolean tryRelease(int release) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个Condition,每个condition都包含了一个condition队列
         *
         * @return
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    public static void main(String[] args) {
        System.out.println(Short.MAX_VALUE);
        System.out.println(new Integer((1 << 16)));
        System.out.println(Integer.toBinaryString(new Integer((1 << 16) )));
        System.out.println(Integer.toHexString(new Integer((1 << 16) )));

        System.out.println(Integer.toBinaryString(new Integer(0x00000000&((1 << 16) - 1))));
        System.out.println(new Integer(0x00010000&((1 << 16) - 1)));
    }
}
