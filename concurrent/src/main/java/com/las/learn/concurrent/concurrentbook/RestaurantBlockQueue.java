package com.las.learn.concurrent.concurrentbook;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by las on 2017/3/18.
 */
public class RestaurantBlockQueue extends Restaurant {

    BlockingQueue<Meal> meals = new ArrayBlockingQueue(this.poolSize);

    public RestaurantBlockQueue(Integer poolSize, Integer total) {
        super(poolSize, total);
    }

    @Override
    public void consume() throws InterruptedException {
        Meal meal = meals.poll(100, TimeUnit.MILLISECONDS);
        if (meal != null) {
            System.out.println(meal);
        } else {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void produce() throws InterruptedException {
        Meal meal = new Meal(this.total--);
        if (meal.getOrderNum() > 0) {
            meals.put(meal);
        } else {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        new RestaurantBlockQueue(5, 200).start(5, 1);
    }
}
