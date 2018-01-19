package com.las.learn.leetcode.p0003;

import org.junit.Test;

public class Solution {

    /**
     * abcabcbb --> abc 3
     * bbbbb --> b 1
     * pwwkew --> wke 3
     *
     * @param str
     * @return
     */
    public int solution(String str) {
        int result = 0;
        String tmp = null;
        for (int i = str.length(); i > 0; i--) {
            if (result < i) {
                for (int j = 0; j <= str.length() - i; j++) {
                    String sub = str.substring(j, i + j);
                    if (hasRepeatStr(sub)) continue;
                    result = i;
                    tmp = sub;
                }
            }
        }
        System.out.println(tmp);
        return result;
    }

    public boolean hasRepeatStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int index;
                String tmp;
                if ((index = str.indexOf(tmp = str.substring(i, j), i + 1)) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("bbbbb"));
        System.out.println(solution("pwwkew"));
        System.out.println(solution("udsgtcazkdgyijogsuvspkqrfrmgyauufocatczdhidpttxlntgdfwwnnktnmqhrejtxmucveflxzkjmdrr"));
    }
}
