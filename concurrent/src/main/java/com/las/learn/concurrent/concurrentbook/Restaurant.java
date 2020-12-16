package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/16
 */
public abstract class Restaurant {
    
    Integer poolSize;
    Integer total;
    AtomicInteger orderNum = new AtomicInteger(0);

    public Restaurant(Integer poolSize, Integer total) {
        this.poolSize = poolSize;
        this.total = total;
    }

    public void start(int chef, int person) {
        for (int i = 0; i < chef; i++) {
//            executors.submit(new Chef(this));
            new Thread(new Chef(this)).start();
        }
        for (int i = 0; i < person; i++) {
//            executors.submit(new WaitPerson(this));
            new Thread(new WaitPerson(this)).start();
        }
    }

    public abstract void consume() throws InterruptedException;

    public abstract void produce() throws InterruptedException;
}

class Chef implements Runnable {
    private Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                restaurant.produce();
            } catch (InterruptedException e) {
            } catch (IllegalMonitorStateException e) {
            }
        }
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                restaurant.consume();
            } catch (InterruptedException e) {
            } catch (IllegalMonitorStateException e) {
            }
        }
    }
}

class Meal {
    private final Integer orderNum;

    public Meal(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}