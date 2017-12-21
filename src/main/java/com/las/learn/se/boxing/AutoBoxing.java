package com.las.learn.se.boxing;

import org.junit.Test;

public class AutoBoxing {

    @Test
    public void integerBox() {
        //在-128~127 之外的数
        Integer i1 = 200;
        Integer i2 = 200;
        System.out.println("i1==i2: " + (i1 == i2));
        // 在-128~127 之内的数
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println("i3==i4: " + (i3 == i4));
        Integer a=null;
        printInteger(a);
        printInt(a);
    }

    @Test
    public void integerUnBox() {
        //在-128~127 之外的数
        int i1 = 1200;
        int i2 = 1200;
        System.out.println("i1==i2: " + (i1 == i2));
        // 在-128~127 之内的数
        int i3 = 100;
        int i4 = 100;
        System.out.println("i3==i4: " + (i3 == i4));
    }

    private void printInt(int a){
        System.out.println("int: "+a);
    }

    private void printInteger(Integer a){
        System.out.println("Integer: "+a);
    }

    @Test
    public void longBox() {
        Long l1 = 1200l;
        Long l2 = 1200l;
        System.out.println("l1==l2: " + (l1 == l2));
        Long l3 = 100l;
        Long l4 = 100l;
        System.out.println("l3==l4: " + (l3 == l4));
    }

    @Test
    public void longUnBox() {
        long l1 = 1200l;
        long l2 = 1200l;
        System.out.println("l1==l2: " + (l1 == l2));
        long l3 = 100l;
        long l4 = 100l;
        System.out.println("l3==l4: " + (l3 == l4));
    }



}
