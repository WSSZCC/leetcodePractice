package test.leetcode2024;

import java.util.Arrays;

/**
 * 不相交的线
 */
public class MaxUncrossedLines {
    public static void main(String[] args) {
        maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4});
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] ints = new int[n][m];
        for (int[] anInt : ints) {
            Arrays.fill(anInt, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    ints[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0 || i == 0) {
                    if (i != 0) {
                        ints[i][j] = Math.max(ints[i - 1][j], ints[i][j]);
                    }
                    if (j != 0) {
                        ints[i][j] = Math.max(ints[i][j - 1], ints[i][j]);
                    }
                } else {
                    ints[i][j] = Math.max(Math.max(ints[i - 1][j], ints[i][j - 1]), ints[i - 1][j - 1] + ints[i][j]);
                }
            }
        }

        return ints[n - 1][m - 1];
    }
}
