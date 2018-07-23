package com.las.learn.gof.specification;

public abstract class CompositeSpecification<T> implements ISpecification<T> {

    @Override
    public abstract boolean isSatisfiedBy(T user);

    @Override
    public ISpecification and(ISpecification spec) {
        return new AndSpecification(this, spec);
    }

    @Override
    public ISpecification not() {
        return new NotSpecification(this);
    }

    @Override
    public ISpecification or(ISpecification spec) {
        return new OrSpecification(this, spec);
    }
}
