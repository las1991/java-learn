package com.las.learn.gof.specification.userExample.spec;

import com.las.learn.gof.specification.CompositeSpecification;
import com.las.learn.gof.specification.userExample.User;

public class UserByAgeThan extends CompositeSpecification<User> {

    private int age;

    public UserByAgeThan(int age) {
        this.age = age;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge() > age;
    }
}
