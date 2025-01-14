package test.leetcode2024;

import java.util.Arrays;

/**
 * 超过阈值的最少操作数 I
 */
public class MinOperations3065 {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<k){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
