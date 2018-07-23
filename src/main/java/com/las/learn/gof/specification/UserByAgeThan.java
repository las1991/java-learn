package com.las.learn.gof.specification;

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
