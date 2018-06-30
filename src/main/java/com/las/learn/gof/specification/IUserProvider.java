package com.las.learn.gof.specification;

public interface IUserProvider {
    Iterable<? extends User> findUser(IUserSpecification userSpecification);
}
