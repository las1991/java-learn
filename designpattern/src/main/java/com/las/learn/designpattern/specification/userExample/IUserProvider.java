package com.las.learn.designpattern.specification.userExample;

import com.las.learn.designpattern.specification.ISpecification;

public interface IUserProvider {
    Iterable<? extends User> findUser(ISpecification userSpecification);
}
