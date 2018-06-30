package com.las.learn.gof.specification;

public class UserByNameLike extends CompositeSpecification {

    private String pattern;

    public UserByNameLike(String pattern) {
        this.pattern = pattern.toLowerCase(); // ignoring locale for now
        this.pattern = this.pattern.replace(".", "\\."); // "\\" is escaped to "\" (thanks, Alan M)
        // ... escape any other potentially problematic characters here
        this.pattern = this.pattern.replace("?", ".");
        this.pattern = this.pattern.replace("%", ".*");
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().toLowerCase().matches(this.pattern);
    }
}
