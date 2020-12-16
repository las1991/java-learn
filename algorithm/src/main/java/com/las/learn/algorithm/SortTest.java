package com.las.learn.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author las
 * @date 19-6-28
 */
public class SortTest {
    Sort sort = new Sort();
    int[] array1 = {
            49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    int[] array2 = {1, 54, 6, 3, 78, 34, 12, 45, 56, 100};

    int[] array3 = {1, 54, 6, 3, 78, 34, 12, 45};

    @Test
    public void test() {
        sort.insertSort(array1);
        System.out.println(Arrays.toString(array1));
    }

    @Test
    public void testBubble() {
        sort.bubbleSort(array1);
        System.out.println(Arrays.toString(array1));
    }

}
