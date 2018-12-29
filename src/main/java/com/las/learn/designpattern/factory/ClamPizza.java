package com.las.learn.designpattern.factory;

public class ClamPizza extends Pizza {

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
        this.name = "Clams Pizza";
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}
