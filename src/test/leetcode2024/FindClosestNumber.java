package test.leetcode2024;

/**
 * 找到最接近 0 的数字
 */
public class FindClosestNumber {
    public int findClosestNumber(int[] nums) {
        int d = Math.abs(nums[0]);
        int v = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (d >= Math.abs(nums[i])) {
                if (d > Math.abs(nums[i])) {
                    v = nums[i];
                } else {
                    v = Math.max(v, nums[i]);
                }
                d = Math.abs(nums[i]);
            }

        }
        return v;
    }
}
