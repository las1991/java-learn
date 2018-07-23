package com.las.learn.gof.specification;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //首先初始化一批用户
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("苏国庆", 23));
        userList.add(new User("国庆牛", 82));
        userList.add(new User("张国庆三", 10));
        userList.add(new User("李四", 10));
        //定义一个用户查询类
        IUserProvider userProvider = new UserProvider(userList);
        //打印出名字包含国庆的人员
        System.out.println("===名字包含国庆的人员===");
        //定义一个规格
        ISpecification spec = new UserByAgeThan(25);
        ISpecification spec2 = new UserByNameLike("%国庆%");
        for (User u : userProvider.findUser(spec.and(spec2))) {
            System.out.println(u);
        }

    }
}
