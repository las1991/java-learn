package com.las.learn.designpattern.factory;

public class VeggiePizza extends Pizza {

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
        this.name = "Veggie Pizza";
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
    }
}
