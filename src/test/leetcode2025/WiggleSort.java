package test.leetcode2025;

import java.util.Arrays;

/**
 * 峰与谷
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-1; i+=2) {
            int a = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = a;
        }
    }


}
