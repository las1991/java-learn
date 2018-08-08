package com.las.learn.gof.specification;

public interface ISpecification<T> {


    boolean isSatisfiedBy(T obj);

}
