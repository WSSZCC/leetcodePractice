package test.leetcode2024;

import java.util.Arrays;

/**
 * 分割字符频率相等的最少子字符串
 */
public class MinimumSubstringsInPartition {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] ints = new int[n + 1];
        int[] ints1 = new int[26];
        Arrays.fill(ints, Integer.MAX_VALUE);
        ints[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxCount = 0;
            int flag = 0;
            Arrays.fill(ints1, 0);
            for (int j = i; j >= 1; j--) {
                int index = s.charAt(j - 1) - 'a';
                ints1[index]++;
                if (ints1[index] == 1) {
                    flag++;
                }
                maxCount = Math.max(maxCount, ints1[index]);
                if (maxCount * flag == (i - j + 1) && ints[j - 1] != Integer.MAX_VALUE) {
                    ints[i] = Math.min(ints[i], ints[j - 1] + 1);
                }
            }
        }
        return ints[n];
    }
}
