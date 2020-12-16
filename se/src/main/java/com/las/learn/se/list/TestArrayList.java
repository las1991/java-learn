package com.las.learn.se.list;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
