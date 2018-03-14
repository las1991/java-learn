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

        System.out.println(solution2(n1, n2));
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

        System.out.println(solution2(n1, n2));
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

        System.out.println(solution2(n1, n2));
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

        System.out.println(solution2(n1, n2));
        System.out.println(solution1(n1, n2));
    }

    @Test
    public void test18add0() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(8);

        ListNode n2 = new ListNode(0);

        System.out.println(solution2(n1, n2));
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

    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        int sum = 0;
        ListNode tmp = l;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum += a + b;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            sum /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (sum > 0) {
            tmp.next = new ListNode(sum);
        }
        return l.next;
    }

    public ListNode solution(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
