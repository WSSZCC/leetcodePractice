package test.leetcode2024;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 求出最多标记下标
 */
public class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int mid = n / 2;
        int j = mid;
        for (int i = 0; i < mid; i++) {
            while (j < n) {
                if (2 * nums[i] <= nums[j]) {
                    set.add(j);
                    j++;
                    break;
                }
                j++;
            }
        }
        return set.size() * 2;
    }
}
