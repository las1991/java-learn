package com.las.learn.concurrent.concurrentbook;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/16
 */
public class RestaurantSynchronized extends Restaurant{

    private static LinkedList<Meal> meals=new LinkedList<Meal>();

    public RestaurantSynchronized(Integer poolSize,Integer total) {
        super(poolSize,total);
    }

    public synchronized void produce() throws InterruptedException {
        if(meals.size()<poolSize){
            if(orderNum.get()<total){
                meals.add(new Meal(orderNum.addAndGet(1)));
                System.out.println("Order up " + orderNum);
            }
            notifyAll();
        }else{
            wait();
        }
    }

    public synchronized void consume() throws InterruptedException {
        if (meals.size()>0){
            Meal meal=meals.removeFirst();
            System.out.println("waitPersion got " + meal);
            notifyAll();
        }else {
            if(orderNum.get()==total){
                Thread.currentThread().interrupt();
            }else{
                wait();
            }
        }
    }

    public static void main(String[] args) {
        new RestaurantSynchronized(5,20);
    }
}