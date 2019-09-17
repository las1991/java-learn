package com.las.learn.effective.i2builder;

import org.junit.Test;

/**
 * @author las
 */
public class PizzaTest {

    @Test
    public void test() {
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside().build();
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();
    }
}
