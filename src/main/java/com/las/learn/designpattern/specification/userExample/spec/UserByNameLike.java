package com.las.learn.gof.specification.userExample.spec;

import com.las.learn.gof.specification.CompositeSpecification;
import com.las.learn.gof.specification.userExample.User;

public class UserByNameLike extends CompositeSpecification<User> {

    private String pattern;

    public UserByNameLike(String pattern) {
        // ignoring locale for now
        this.pattern = pattern.toLowerCase();
        // "\\" is escaped to "\" (thanks, Alan M)
        this.pattern = this.pattern.replace(".", "\\.");
        // ... escape any other potentially problematic characters here
        this.pattern = this.pattern.replace("?", ".");
        this.pattern = this.pattern.replace("%", ".*");
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().toLowerCase().matches(this.pattern);
    }
}
