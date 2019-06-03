package com.las.learn.geektime.concurrentInAction.mutex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author las
 * @date 19-6-3
 */
public class Allocator {
    private List<Object> als = new ArrayList<>();

    public enum AllocatorSingleton {
        INSTANCE;
        private Allocator instance;

        AllocatorSingleton() {
            instance = new Allocator();
        }

        public Allocator getInstance() {
            return instance;
        }
    }

    private Allocator() {
    }

    public Allocator(List<Object> als) {
        this.als = als;
    }

    public synchronized boolean applyBlock(Object from, Object to) {

        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    public synchronized void apply(Object from, Object to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        als.add(from);
        als.add(to);
    }

    public synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
