package test.leetcode2025;

import java.util.Arrays;

/**
 * 使所有字符相等的最小成本
 */
public class MinimumCost {
    public long minimumCost(String s) {
        int n = s.length();
        long[] longs = new long[n];
        Arrays.fill(longs, 0);
        char[] chars = s.toCharArray();
        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] == chars[i + 1]) {
                longs[i] = longs[i + 1];
            } else {
                longs[i] = longs[i+1]+n-1-i;
            }
        }
        long pre = 0;
        long minValue = longs[0];
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                pre += i;
            }
            minValue = Math.min(minValue,longs[i]+pre);
        }
        return minValue;
    }
}
