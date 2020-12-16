package com.las.learn.designpattern.specification;

/**
 * 进行and运算
 * @param <T>
 */
public class AndSpecification<T> extends CompositeSpecification<T> {
    /**
     * 传递两个规格书进行and操作
     */
    private ISpecification left;
    private ISpecification right;

    public AndSpecification(ISpecification _left, ISpecification _right) {
        this.left = _left;
        this.right = _right;
    }

    @Override
    public boolean isSatisfiedBy(T user) {
        return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
    }


}
