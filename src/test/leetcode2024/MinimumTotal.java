package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int maxLen = triangle.get(n - 1).size();
        int[] ints = new int[maxLen];
        Arrays.fill(ints, 0);
        ints[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 2; j >= 0; j--) {
                if (j == list.size() - 2) {
                    ints[j + 1] = ints[j] + list.get(j + 1);
                }
                if (j == 0) {
                    ints[0] += list.get(j);
                    break;
                }
                ints[j] = Math.min(ints[j - 1], ints[j]) + list.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int anInt : ints) {
            min = Math.min(min, anInt);
        }
        return min;
    }

}
