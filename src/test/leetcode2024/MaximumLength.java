package test.leetcode2024;

import java.util.*;

/**
 * 求出最长好子序列 I
 */
public class MaximumLength {
    public static void main(String[] args) {
        maximumLength(new int[]{1, 2, 2, 1, 1, 3}, 2);
    }

    public static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        Map<Integer, int[]> map = new HashMap<>();
        int[] ints = initInts(k);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, initInts(k));
            }
            int[] ints1 = map.get(num);
            for (int j = 0; j < k; j++) {
                ints1[j]++;
                if (j > 0) {
                    ints1[j] = Math.max(ints1[j], ints[j - 1] + 1);
                }
            }
            for (int j = 0; j < k; j++) {
                ints[j] = Math.max(ints[j], ints1[j]);
                if (j > 0) {
                    ints[j] = Math.max(ints[j], ints[j - 1]);
                }
            }
        }
        return ints[k];
    }

    private static int[] initInts(int k) {
        int[] ints = new int[k + 1];
        Arrays.fill(ints,0);
        return ints;
    }
}
