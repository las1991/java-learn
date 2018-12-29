package com.las.learn.designpattern.singleton;

/**
 * @author las
 * @date 18-12-27
 */
public class DoubleCheckedLockingSingleton {
    //volatile 确保instance被初始化成实例时，多个线程正确的处理instance变量
    private volatile static DoubleCheckedLockingSingleton instance;

    public static DoubleCheckedLockingSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
