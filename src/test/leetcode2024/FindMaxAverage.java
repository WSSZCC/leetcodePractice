package test.leetcode2024;

/**
 * 子数组最大平均数 I
 */
public class FindMaxAverage {
    public static void main(String[] args) {

    }

    private static double findMaxAverage(int[] nums, int k) {
        int maxValue = 0;
        int temp = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            maxValue += nums[i];
            temp = maxValue;
        }
        for (int i = k; i < n; i++) {
            temp = temp + nums[i] - nums[i-k];
            maxValue = Math.max(maxValue,temp);
        }
        return 1.0*maxValue/k;
    }

}
