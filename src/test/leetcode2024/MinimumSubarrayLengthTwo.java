package test.leetcode2024;

/**
 * 或值至少为 K 的最短子数组 II
 */
public class MinimumSubarrayLengthTwo {
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0){
            return 1;
        }
        int n = nums.length;
        int[] bits = new int[30];
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 30; j++) {
                bits[i] = (nums[i]>>j)&1;
            }
            while (left<=i&&check(bits,k)){
                ans = Math.min(ans,i-left+1);
                for (int j = 0; j < 30; j++) {
                    bits[i] -= (nums[i]>>j)&1;
                }
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private boolean check(int[] bits, int k) {
        int sum = 0;
        for (int i = 0; i < bits.length; i++) {
            if(bits[i]>0){
                sum|=(1<<i);
            }
        }
        return sum>=k;
    }
}
