package test.leetcode2024;

import java.util.Arrays;

/**
 * 数组的最大美丽值
 */
public class MaximumBeauty {
    public static void main(String[] args) {
        maximumBeauty(new int[]{48,93,96,19},24);
    }

    public static int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxLen = nums[n-1]-nums[0]<=2*k?n:0;
        if(maxLen==n){
            return n;
        }
        int index = 0;
        long[] ints = new long[n];
        ints[0] = nums[0]+k;
        for (int i = 1; i < n; i++) {
            long left = Math.max(nums[i]-k,0);
            long right = nums[i]+k;
            if(left>ints[index]){
                maxLen =  Math.max(maxLen,i-index);
                while (index<i&&left>ints[index]){
                    index++;
                }
            }
            ints[i] = right;
        }
        return Math.max(n-index,maxLen);
    }
}
