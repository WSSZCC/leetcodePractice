package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出缺失和重复的数字
 */
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 2}};
        findMissingAndRepeatedValues(ints);
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int a = 0;
        int sum = 0;
        int relSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n * n; i++) {
            relSum +=i;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                sum += ints[j];
                if (set.contains(ints[j])) {
                    a = ints[j];
                } else {
                    set.add(ints[j]);
                }
            }
        }
        return new int[]{a,a+relSum-sum};
    }
}
