package test.leetcode2024;

import java.util.PriorityQueue;

/**
 * K 次乘运算后的最终数组 I
 */
public class GetFinalState {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            queue.add(new int[]{multiplier * poll[0], poll[1]});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            nums[poll[1]] = poll[0];
        }
        return nums;
    }
}
