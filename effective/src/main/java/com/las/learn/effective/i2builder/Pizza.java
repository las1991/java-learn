package com.las.learn.effective.i2builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author las
 */
public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    protected Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        //Subclasses must overrride this method to return "this"
        protected abstract T self();
    }
}
