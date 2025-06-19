package test.leetcode2025;

import java.util.Arrays;

/**
 * 划分数组使最大差为 K
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;
        int value = nums[0]+k;
        for (int i = 1; i < n; i++) {
            if(nums[i]>value){
                ans++;
                value = nums[i]+k;
            }
        }
        return ans;
    }
}
