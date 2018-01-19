package com.las.learn.leetcode.p0002;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode tmp = this;
        do {
            sb.append(tmp.val);
            tmp = tmp.next;
            if (null != tmp) {
                sb.append(" -> ");
            } else {
                break;
            }
        } while (true);
        return sb.toString();
    }
}
