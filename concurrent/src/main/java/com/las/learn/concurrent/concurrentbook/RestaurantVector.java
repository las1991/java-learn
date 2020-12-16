package com.las.learn.concurrent.concurrentbook;

import java.util.Vector;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/4
 */
public class RestaurantVector extends Restaurant{

    Vector<Meal> meals = new Vector<Meal>();

    public RestaurantVector(Integer poolSize,Integer total) {
        super(poolSize,total);
    }

    public void produce() throws InterruptedException {
        if (meals.size() >= poolSize) {
            notifyAll();
        } else {
            if (orderNum.get()<total){
                meals.add(new Meal(orderNum.addAndGet(1)));
                System.out.println("Order up " + orderNum);
                wait();
            }
        }
    }

    public void consume() throws InterruptedException {
        if (meals.size() > 0) {
            Meal meal = meals.remove(0);
            System.out.println("waitPersion got " + meal);
            if (meal.getOrderNum()==total){
                Thread.currentThread().interrupt();
            }
            wait();
        } else {
            notifyAll();
        }
    }

    public static void main(String[] args) {
        new RestaurantVector(5,20);
    }
}


