package test.leetcode2024;

/**
 * 最大子数组和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return getMaxValue(nums, n);
    }

    private int getMaxValue(int[] nums, int n) {
        int maxValue = nums[0];
        int target = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num >= 0 && target < 0) {
                target = num;
            } else {
                target += num;
            }
            maxValue = Math.max(maxValue, target);
            maxValue = Math.max(maxValue, num);
        }
        return maxValue;
    }
}
