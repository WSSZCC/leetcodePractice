package test.leetcode2024;

import java.util.HashSet;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer value : set) {
            if (!set.contains(value - 1)) {
                int count = 1;
                int temp = value + 1;
                while (set.contains(temp)) {
                    temp++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
