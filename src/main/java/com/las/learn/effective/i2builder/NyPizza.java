package com.las.learn.effective.i2builder;

import java.util.Objects;

/**
 * @author las
 */
public class NyPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    protected NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
