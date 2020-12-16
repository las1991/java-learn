package com.las.learn.se;

/**
 * Created by las on 2016/12/26.
 */
public class SubClass extends Parent {
    // 静态变量
    public static String staticField = "SubClass-静态变量";
    // 变量
    public String field = "SubClass-变量";

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("SubClass-静态初始化块");
    }

    // 初始化块
    {
        System.out.println(field);
        System.out.println("SubClass-初始化块");
    }

    // 构造器
    public SubClass() {
        System.out.println("SubClass-构造器");
        System.out.println("i=" + i + ",j=" + j);
    }
}
