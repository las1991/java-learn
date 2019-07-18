package com.las.learn.algorithm;

/**
 * @author las
 * @date 19-7-17
 */
public class DynamicProgramming {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String result = "";

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int left = 0, right = 0, max = 0;

        for (int r = 0; r < chars.length; r++) {
            for (int l = 0; l < r; l++) {
                if (chars[l] == chars[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                }
                if (dp[l][r] && r - l > max) {
                    left = l;
                    right = r;
                    max = r - l;
                }
            }
        }

        result = s.substring(left, right);

        return result;
    }

    
}
