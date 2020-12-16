package com.las.learn.geektime.concurrentInAction.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author las
 * @date 19-6-20
 */
public class StampedLockTemplate {

    final StampedLock stampedLock = new StampedLock();

    public void read() {
        long stamp = stampedLock.tryOptimisticRead();
        //do read
        
        //校验stamp
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                //do read
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
    }

    public void write() {
        long stamp = stampedLock.writeLock();
        try {
            //do write
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
}
