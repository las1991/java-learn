package com.las.learn.gof.specification;

public class UserByNameEqual extends CompositeSpecification<User> {
    /**
     * 基准姓名
     */
    private String name;

    /**
     * 构造函数传递基准姓名
     * @param _name
     */
    public UserByNameEqual(String _name) {
        this.name = _name;
    }

    /**
     * 检验用户是否满足条件
     * @param user
     * @return
     */
    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().equals(name);
    }
}
