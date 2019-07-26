package com.las.learn.concurrent.threadPool;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author las
 * @date 19-7-26
 */
public class MyPoolSizeCalculator extends PoolSizeCalculator{

    @Override
    protected Runnable createTask() {
        return new AsyncIOTask();
    }

    @Override
    protected BlockingQueue createWorkQueue() {
        return new LinkedBlockingQueue(1000);
    }

    @Override
    protected long getCurrentThreadCPUTime() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }

    public static void main(String[] args) {
        PoolSizeCalculator poolSizeCalculator = new MyPoolSizeCalculator();
        poolSizeCalculator.calculateBoundaries(new BigDecimal(1.0), new BigDecimal(100000));
    }

}
