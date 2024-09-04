package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 让所有学生保持开心的分组方法数
 */
public class CountWays {

    public int countWays(List<Integer> nums) {
        int n = nums.size();
        int[] ints = new int[n];
        for (int i = 0; i < nums.size(); i++) {
            ints[i] = nums.get(i);
        }
        Arrays.sort(ints);
        int count = 0;
        int flag = ints[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            int num = ints[i];
            if (check(n, flag, i, num)) {
                count++;
            }
            flag = num;
        }
        if (ints[0] != 0) {
            count++;
        }
        return count;
    }

    private boolean check(int n, int flag, int i, int num) {
        return num < i + 1 && (i == n - 1 || flag > i + 1);
    }
}
