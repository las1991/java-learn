package com.las.learn.se;

/**
 * Created by las on 2016/12/26.
 */
public class Parent {
    // 静态变量
    public static String staticField = "Parent静态变量";
    // 变量
    public String field = "Parent-变量";
    protected int i=0;
    protected int j=1;

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("Parent-静态初始化块");
    }

    // 初始化块
    {
        System.out.println(field);
        System.out.println("Parent-初始化块");
    }

    // 构造器
    public Parent() {
        System.out.println("Parent-构造器");
        System.out.println("i=" + i + ",j=" + j);
        j=20;
    }
}
