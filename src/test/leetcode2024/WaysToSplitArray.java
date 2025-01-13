package test.leetcode2024;

/**
 * 分割数组的方案数
 */
public class WaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        long sum1 = 0;
        for (int i = 0; i < n - 1; i++) {
            sum -= nums[i];
            sum1 += nums[i];
            if (sum <= sum1) {
                count++;
            }
        }
        return count;
    }
}
