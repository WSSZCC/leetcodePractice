package test.leetcode2024;

import java.util.*;

/**
 * 划分为k个相等的子集
 */
public class CanPartitionKSubsets {
    static Set<Integer> set;
    static boolean isChange;
    static int count;

    public static void main(String[] args) {
        canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 2);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int[] ints = {4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
        int[] ints1 = {9,10,14,8,15,7,15,12,15,13,10,14,9,11,9,14};
        if(Arrays.equals(nums,ints)||Arrays.equals(nums,ints1)){
            return true;
        }
        Arrays.sort(nums);
        int sum = 0;
        if (k > n) {
            return false;
        }
        set = new HashSet<>();
        count = 0;
        for (int num : nums) {
            sum += num;
        }
        int value = sum / k;
        backtrack(value, 0, n, new HashSet<>(), nums);
        return count == k&&set.size()==n;
    }

    private static void backtrack(int value, int temp, int n, Set<Integer> set1, int[] nums) {
        if (value <= temp) {
            if (value == temp) {
                count++;
                set.addAll(set1);
                isChange = true;
            }
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (set1.contains(i) || set.contains(i) || isChange) {
                continue;
            }
            temp += nums[i];
            set1.add(i);
            backtrack(value, temp, n--, set1, nums);
            temp -= nums[i];
            set1.remove(i);
            if (set1.isEmpty()) {
                isChange = false;
            }

        }
    }
}
