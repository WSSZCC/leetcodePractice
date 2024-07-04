package test.leetcode2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大子序列的分数
 */
public class MaxScore {
    public static void main(String[] args) {
        maxScore(new int[]{1,3,3,2},new int[]{2,1,3,4},3);
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> -a[0]));
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            queue.add(new long[]{nums2[i], i});
        }
        long minNum2Value = 0;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        long sumNum1Value = 0;
        for (int i = 0; i < k; i++) {
            long[] poll = queue.poll();
            queue1.add(nums1[(int)poll[1]]);
            minNum2Value = poll[0];
            sumNum1Value += nums1[(int) poll[1]];
        }
        long maxValue = sumNum1Value * minNum2Value;
        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            if (nums1[(int) poll[1]] > queue1.peek()) {
                Integer poll1 = queue1.poll();
                minNum2Value = poll[0];
                sumNum1Value = sumNum1Value-poll1+nums1[(int) poll[1]];
                queue1.add(nums1[(int) poll[1]]);
                maxValue = Math.max(maxValue,minNum2Value*sumNum1Value);

            }
        }
        return maxValue;
    }
}
