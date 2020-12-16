package com.las.learn.designpattern.factory;

import com.las.learn.designpattern.factory.ingredient.*;

/**
 * @author las
 * @date 18-12-26
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();
}
