package com.las.learn.gof.specification;

/**
 * or运算
 * @param <T>
 */
public class OrSpecification<T> extends CompositeSpecification<T> {
    /**
     * 左右两个规格书
     */
    private ISpecification left;
    private ISpecification right;

    public OrSpecification(ISpecification _left, ISpecification _right) {
        this.left = _left;
        this.right = _right;
    }

    @Override
    public boolean isSatisfiedBy(T user) {
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
