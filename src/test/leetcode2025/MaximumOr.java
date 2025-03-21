package test.leetcode2025;

import java.util.Arrays;

/**
 * 最大或值
 */
public class MaximumOr {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] ints = new int[n];
        Arrays.fill(ints,0);
        for (int i = n-2; i >= 0; i--) {
            ints[i] = ints[i+1]|nums[i];
        }
        long ans = 0;
        long pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,pre| (long) nums[i] <<k|ints[i]);
            pre|=nums[i];
        }
        return ans;
    }
}
