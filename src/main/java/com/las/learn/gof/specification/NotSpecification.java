package com.las.learn.gof.specification;

/**
 * not操作
 * @param <T>
 */
public class NotSpecification<T> extends CompositeSpecification<T> {

    /**
     * 传递一个规格书
     */
    private ISpecification spec;

    public NotSpecification(ISpecification _spec) {
        this.spec = _spec;
    }

    @Override
    public boolean isSatisfiedBy(T user) {
        return !spec.isSatisfiedBy(user);
    }
}
