package test.leetcode2024;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 长度为 K 子数组中的最大和
 */
public class MaximumSubarraySum {

    public  long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        long ans = 0;
        long temp = 0;
        while (index < n) {
            if (set.contains(nums[index])) {
                while (!queue.isEmpty()) {
                    Integer value = queue.pollFirst();
                    temp -= value;
                    set.remove(value);
                    if (value == nums[index]) {
                        break;
                    }
                }
            }
            set.add(nums[index]);
            if (queue.size() == k) {
                int value = queue.pollFirst();
                set.remove(value);
                temp-=value;
            }
            queue.add(nums[index]);
            temp += nums[index];

            if (queue.size() == k) {
                ans = Math.max(ans, temp);
            }
            index++;

        }
        return ans;
    }
}
