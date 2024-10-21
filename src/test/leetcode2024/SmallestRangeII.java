package test.leetcode2024;

import java.util.Arrays;

/**
 * 最小差值 II
 */
public class SmallestRangeII {
    public static void main(String[] args) {
        System.out.println(smallestRangeII(new int[]{4,1,8,10},3));
    }

    public static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int res = max - min;
        for (int i = 0; i < nums.length - 1; i++) {
            int v1 = nums[i];
            int v2 = nums[i + 1];
            res = Math.min(res, Math.max(max - k, v1 + k) - Math.min(min + k, v2 - k));
        }
        return res;
    }
    public static int smallestRangeII1(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 1) {
            return 0;
        }
        int maxValue = nums[0] + k;
        int minValue = nums[0] + k;
        for (int i = 1; i < n; i++) {
            int value = nums[i] - k;
            if (value < 0||nums[i]==nums[i-1]) {
                maxValue = nums[i] + k;
                continue;
            }
            if (value >= minValue) {
                maxValue = Math.max(maxValue, value);
            } else {
                if (maxValue - value <= nums[i] + k - minValue) {
                    minValue = value;
                } else {
                    maxValue = nums[i] + k;
                }
            }

        }

        return maxValue - minValue;
    }
}
