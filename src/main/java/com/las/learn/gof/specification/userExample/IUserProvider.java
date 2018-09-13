package com.las.learn.gof.specification.userExample;

import com.las.learn.gof.specification.ISpecification;

public interface IUserProvider {
    Iterable<? extends User> findUser(ISpecification userSpecification);
}
