package com.las.learn.designpattern.specification;

public interface ISpecification<T> {


    boolean isSatisfiedBy(T obj);

}
