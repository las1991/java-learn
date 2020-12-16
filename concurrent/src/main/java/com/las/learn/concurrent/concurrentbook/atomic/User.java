package com.las.learn.concurrent.concurrentbook.atomic;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/12
 */
public class User {
    public volatile String name;
    public volatile int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }


    public int getOld() {
        return old;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", old=" + old +
                '}';
    }
}
