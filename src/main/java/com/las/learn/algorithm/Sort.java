package com.las.learn.algorithm;

import java.util.Arrays;

/**
 * Created by las on 2017/3/12.
 */
public class Sort {
    /**
     * 快速排序 O(N*logN)
     */
    public void quickSort(int[] a) {

    }

    /**
     * 插入排序 o(n^2)
     * 基本思想：
     * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
     * 现在要把第n个数插到前面的有序数中，使得这 n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     */
    public void insertSort(int[] a) {
        int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 基本思想：算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若干组，
     * 每组中记录的下标相差 d.对每组中全部元素进行直接插入排序，
     * 然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
     * 当增量减到 1 时，进行直接插入排序后，排序完成。
     */
    public void shellSort(int[] a) {
        double d = a.length;
        while (d > 1) {
            d = Math.ceil(d / 2);
            for (int x = 0; x < (int) d; x++) {
                for (int i = x + (int) d; i < a.length; i += (int) d) {
                    for (int j = i; j >= x + (int) d; j -= (int) d) {
                        if (a[j] < a[j - (int) d]) {
                            int tmp = a[j];
                            a[j] = a[j - (int) d];
                            a[j - (int) d] = tmp;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换;
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public void selectSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < tmp) {
                    a[i] = a[j];
                    a[j] = tmp;
                    tmp = a[i];
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public void heapSort(int a[]) {

    }
}
