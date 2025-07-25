package test.leetcode2025;

import java.util.Arrays;

/**
 * 删除后的最大子数组元素和
 */
public class MaxSum3487 {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int temp = nums[n-1];
        int sum = temp;
        for (int i = n-2; i >=0; i--) {
            if(nums[i]<=0){
                break;
            }
            if(nums[i]!=temp){
                temp = nums[i];
                sum+=temp;
            }
        }
        return sum;
    }
}
