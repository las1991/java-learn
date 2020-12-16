package com.las.learn.designpattern.factory;

public class CheesePizza extends Pizza {

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
        this.name = "Cheese Pizza";
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
