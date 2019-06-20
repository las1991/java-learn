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
}
