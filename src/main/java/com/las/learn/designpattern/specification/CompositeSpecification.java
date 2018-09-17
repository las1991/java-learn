package com.las.learn.designpattern.specification;

public abstract class CompositeSpecification<T> implements ISpecification<T> {

    @Override
    public abstract boolean isSatisfiedBy(T user);

    /**
     * and操作
     *
     * @param spec
     * @return
     */
    public CompositeSpecification and(ISpecification spec) {
        return new AndSpecification(this, spec);
    }

    /**
     * not操作
     *
     * @return
     */
    public CompositeSpecification not() {
        return new NotSpecification(this);
    }

    /**
     * or操作
     *
     * @param spec
     * @return
     */
    public CompositeSpecification or(ISpecification spec) {
        return new OrSpecification(this, spec);
    }
}
