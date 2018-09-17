package com.las.learn.designpattern.strategy;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >> ");
    }
}
