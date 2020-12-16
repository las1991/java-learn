package com.las.learn.geektime.concurrentInAction.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author las
 * @date 19-6-20
 */
public class Point {
    int x, y;

    final StampedLock stampedLock = new StampedLock();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //乐观读 升级 悲观读
    double distanceFromOrigin() {

        long stamp = stampedLock.tryOptimisticRead();

        int curX = x, curY = y;

        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(curX * curX + curY * curY);
    }

    //读升级写
    void moveIfAtOrigin(int newX, int newY) {
        long stamp = stampedLock.readLock();
        try {
            while (x == 0 && y == 0) {
                long ws = stampedLock.tryConvertToWriteLock(stamp);
                if (ws != 0) {
                    x = newX;
                    y = newY;
                    stamp = ws;
                    break;
                } else {
                    stampedLock.unlockRead(stamp);
                    stamp = stampedLock.writeLock();
                }
            }
        } finally {
            stampedLock.unlock(stamp);
        }
    }

}
