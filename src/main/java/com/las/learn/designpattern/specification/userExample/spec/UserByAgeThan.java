package com.las.learn.designpattern.specification.userExample.spec;

import com.las.learn.designpattern.specification.CompositeSpecification;
import com.las.learn.designpattern.specification.userExample.User;

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
