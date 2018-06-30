package com.las.learn.gof.specification;

public interface IUserSpecification {

    boolean isSatisfiedBy(User user);

    //and操作
    IUserSpecification and(IUserSpecification spec);

    //not操作
    IUserSpecification not();

    //or操作
    IUserSpecification or(IUserSpecification spec);


}
