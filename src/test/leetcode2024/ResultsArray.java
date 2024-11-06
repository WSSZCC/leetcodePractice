package test.leetcode2024;

import java.util.Arrays;

/**
 * 长度为 K 的子数组的能量值 I
 */
public class ResultsArray {
    public  int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if(n==1||k==1){
            return nums;
        }
        int maxLen = n - k + 1;
        int[] ints = new int[maxLen];
        Arrays.fill(ints,-1);
        int flag = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i]==nums[i-1]+1){
                flag++;
            }else {
                flag = 1;
            }
            if(flag>=k){
                ints[i-k+1] = nums[i];
            }
        }

        return ints;
    }
}
