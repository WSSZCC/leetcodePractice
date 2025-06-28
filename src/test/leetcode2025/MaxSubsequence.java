package test.leetcode2025;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  找到和最大的长度为 K 的子序列
 */
public class MaxSubsequence {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int a = o1;
            int b = o2;
            return nums[b]-nums[a];
        });
        for (int i = 0; i < k; i++) {
            queue.add(i);
        }
        for (int i = k; i < n; i++) {
            if(nums[queue.peek()]<nums[i]){
                queue.poll();
                queue.add(i);
            }
        }
        Integer[] integers = queue.toArray(new Integer[0]);
        Arrays.sort(integers);
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = nums[integers[i]];
        }
        return ints;
    }
}
