package com.las.learn.gof.specification;

import java.util.ArrayList;
import java.util.List;

public class UserProvider implements IUserProvider {

    private List<User> data;

    public UserProvider(List<User> data) {
        this.data = data;
    }

    @Override
    public Iterable<? extends User> findUser(ISpecification userSpecification) {
        ArrayList<User> result = new ArrayList<>();
        data.forEach(x -> {
            if (userSpecification.isSatisfiedBy(x)) {
                result.add(x);
            }
        });
        return result;
    }
}
