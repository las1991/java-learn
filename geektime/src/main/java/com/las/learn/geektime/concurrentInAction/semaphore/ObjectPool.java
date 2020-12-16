package com.las.learn.geektime.concurrentInAction.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author las
 * @date 19-6-18
 */
public class ObjectPool<T, R> {

    final List<T> pool;
    final Semaphore semaphore;

    public ObjectPool(int size, T t) {
        this.pool = new Vector<>(size);

        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }


    R exec(Function<T, R> function) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectPool<Long, String> objectPool = new ObjectPool<Long, String>(10, 2l);
        objectPool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
