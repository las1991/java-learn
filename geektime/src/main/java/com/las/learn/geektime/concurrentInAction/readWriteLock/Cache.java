package com.las.learn.geektime.concurrentInAction.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author las
 * @date 19-6-18
 */
public class Cache<K, V> {

    final Map<K, V> map = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock rl = rwl.readLock();
    final Lock wl = rwl.writeLock();


    V get(K key) {
        V v = null;
        rl.lock();
        try {
            v = map.get(key);
        } finally {
            rl.unlock();
        }

        if (v != null) {
            return v;
        }

        wl.lock();
        try {
            v = map.get(key);
            if (null != v) {
                return v;
            }


        } finally {
            wl.unlock();
        }

        return v;
    }

    V put(K key, V value) {
        wl.lock();
        try {
            return map.put(key, value);
        } finally {
            wl.unlock();
        }
    }
}
