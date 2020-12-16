package com.las.learn.geektime.concurrentInAction.monitor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author las
 * @date 19-6-18
 */
public class BlockedQueue<E> {

    private final int capacity;

    /**
     * Current number of elements
     */
    private final AtomicInteger count = new AtomicInteger();

    /**
     * Head of linked list.
     * Invariant: head.item == null
     */
    transient Node<E> head;

    /**
     * Tail of linked list.
     * Invariant: last.next == null
     */
    private transient Node<E> last;

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public BlockedQueue(int capacity) {
        this.capacity = capacity;
        last = head = new Node<E>(null);
    }


    void enq(E t) throws InterruptedException {
        lock.lock();
        try {
            while (count.get() == capacity) {
                notFull.await();
            }
            enqueue(new Node<>(t));
            count.getAndIncrement();
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(Node<E> node) {
        last = last.next = node;
    }

    E deq() throws InterruptedException {
        E item = null;
        lock.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            item = dequeue();
            count.getAndDecrement();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }

        return item;
    }

    private E dequeue() {
        Node<E> h = head;
        Node<E> first = head.next;
        h.next = h;
        head = first;
        E item = first.item;
        first.next = null;
        return item;
    }

    static class Node<E> {
        E item;
        Node<E> next;

        Node(E x) {
            item = x;
        }
    }
}
