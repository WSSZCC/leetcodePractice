package test.leetcode2024;

import java.util.Arrays;

/**
 * 或值至少 K 的最短子数组 I
 */
public class MinimumSubarrayLength {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int len = Integer.MAX_VALUE;
        for (int i = n-1; i >=0; i--) {
            int v = nums[i];
            if(v>=k){
                return 1;
            }
            for (int j = i-1; j >=0; j--) {
                v=v|nums[j];
                if(v>=k){
                    len= Math.min(i-j+1,len);
                    break;
                }
            }
        }
        return len==Integer.MAX_VALUE?-1:len;
    }
}
