package com.las.learn.se.list;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestVector {

    public static void main(String[] args) {
        Vector<String> list = new Vector<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<String>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        for (String s : strings) {
            strings.remove("a");
            System.out.println(s);
        }
    }
}
