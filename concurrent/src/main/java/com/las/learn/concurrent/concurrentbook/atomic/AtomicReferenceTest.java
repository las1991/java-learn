package com.las.learn.concurrent.concurrentbook.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/12
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();
        User user = new User("tom", 15);
        userAtomicReference.set(user);
        User updateUser = new User("Shinichi", 17);
        userAtomicReference.compareAndSet(user, updateUser);
        System.out.println(user);

        AtomicReferenceFieldUpdater<User, String> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(User.class, String.class, "name");
        fieldUpdater.compareAndSet(user, "tom", "jerry");
        System.out.println(user);
        AtomicMarkableReference<User> markableReference = new AtomicMarkableReference<User>(user, true);

    }

}