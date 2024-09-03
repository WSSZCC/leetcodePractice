package test.leetcode2024;

import java.util.Arrays;

/**
 * 一个小组的最大实力值
 */
public class MaxStrength {
    public static void main(String[] args) {
        maxStrength(new int[]{-2, -3, 8, 9});
    }

    public static long maxStrength(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return calMaxSum(nums, n);
    }

    private static long calMaxSum(int[] nums, int n) {
        long sum = 1;
        int count = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            if (num < 0) {
                count++;
                index = i;
            }
            sum *= num;
        }
        if (count % 2 == 1) {
            sum /= nums[index];
        }
        if (count <= 1 && nums[n - 1] == 0) {
            sum = 0;
        }
        return sum;
    }
}
