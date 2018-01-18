package com.las.learn.leetcode.p0002;

import org.junit.Test;

public class Solution {

    @Test
    public void test234add124() {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(3);
        n1.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(4);

        System.out.println(solution1(n1, n2));
    }

    @Test
    public void test615add741() {
        ListNode n1 = new ListNode(6);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(7);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(1);

        System.out.println(solution1(n1, n2));
    }

    @Test
    public void test999add999() {
        ListNode n1 = new ListNode(9);
        n1.next = new ListNode(9);
        n1.next.next = new ListNode(9);

        ListNode n2 = new ListNode(9);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(9);

        System.out.println(solution1(n1, n2));
    }

    @Test
    public void test243add564() {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        System.out.println(solution1(n1, n2));
    }

    @Test
    public void test18add0() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(8);

        ListNode n2 = new ListNode(0);

        System.out.println(solution1(n1, n2));
    }

    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode l = null;
        int carry = 0;
        ListNode last = null;
        while (l1 != null || l2 != null) {
            int tmp = (null != l1 ? l1.val : 0) + (null != l2 ? l2.val : 0);
            if (tmp >= 10) {
                carry = tmp / 10;
                tmp = tmp % 10;
            }
            ListNode now = new ListNode(tmp);
            if (l == null) {
                last = l = now;
            } else {
                last.next = now;
                last = now;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (carry == 0) {
                continue;
            }
            if (l1 != null) {
                l1.val += carry;
            } else if (l2 != null) {
                l2.val += carry;
            } else {
                last.next = new ListNode(carry);
                break;
            }
            carry = 0;
        }
        return l;
    }

}
