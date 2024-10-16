package test.leetcode2024;

import java.util.Arrays;

/**
 * 最小元素和最大元素的最小平均值
 */
public class MinimumAverage {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < length/2; i++) {
            minValue = Math.min(nums[i]+nums[length-1-i],minValue);
        }
        return minValue/2.0d;
    }
}
