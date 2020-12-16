package com.las.learn.geektime.jvm.methodCall;

/**
 * @author las
 * @date 19-7-4
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    final public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
