package com.las.learn.se;

/**
 * Created by las on 2016/12/26.
 * 对于静态变量、静态初始化块、变量、初始化块、构造器，它们的初始化顺序依次是
 * （静态变量、静态初始化块）>（变量、初始化块）>构造器。
 * 我们也可以通过下面的测试代码来验证这一点
 */
public class InitialOrderTest {
    // 静态变量
    public static String staticField = "main-静态变量";
    // 变量
    public String field = "main-变量";

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("main静态初始化块");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        new SubClass();
    }
}