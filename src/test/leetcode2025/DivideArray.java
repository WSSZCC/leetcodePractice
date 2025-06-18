package test.leetcode2025;

import java.util.Arrays;

/**
 * 划分数组并满足最大差限制
 */
public class DivideArray {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ints = new int[n / 3][3];
        int index = 0;
        for (int i = 0; i < n; i+=3) {
            if(nums[i+1]-nums[i]>k||nums[i+2]-nums[i+1]>k){
                return new int[][]{};
            }
            ints[index] = new int[]{nums[i],nums[i+1],nums[i+2]};
            index++;
        }
        return ints;
    }
}
