package com.las.learn.designpattern.decorator;

public class StarBuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new Whip(new Mocha(new Mocha(new DarkRoast())));
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

    }
}
