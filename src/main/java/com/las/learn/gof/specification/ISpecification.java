package com.las.learn.gof.specification;

public interface ISpecification<T> {


    boolean isSatisfiedBy(T obj);

    /**
     * and操作
     *
     * @param spec
     * @return
     */
    ISpecification and(ISpecification spec);

    /**
     * not操作
     *
     * @return
     */
    ISpecification not();

    /**
     * or操作
     *
     * @param spec
     * @return
     */
    ISpecification or(ISpecification spec);


}
