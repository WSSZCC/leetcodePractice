package test.leetcode2024;

import java.util.Arrays;

/**
 * 寻找数组的中心下标
 */
public class PivotIndex {
    public static void main(String[] args) {
        pivotIndex(new int[]{-1,-1,1,1,5});
    }

    private static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (sum - nums[0] == 0) {
            return 0;
        }
        int leftValue = 0;
        for (int i = 1; i < n; i++) {
            leftValue+=nums[i-1];
            if(sum - nums[i] == 2*leftValue){
                return i;
            }
        }
        return -1;
    }
}
