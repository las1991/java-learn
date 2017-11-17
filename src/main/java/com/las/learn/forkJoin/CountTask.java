package com.las.learn.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by las on 2017/3/28.
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;//阈值

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            //如果任务足够小，直接计算
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int mod = (end + start) / 2;
            CountTask leftTask = new CountTask(start, mod);
            CountTask rightTask = new CountTask(mod, end);
            //执行
            leftTask.fork();
            rightTask.fork();

            //收集结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并结果
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1, 100);
        Future<Integer> future = pool.submit(task);

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
