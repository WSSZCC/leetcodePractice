package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 跳跃游戏 VI
 */
public class MaxResult {
    public static void main(String[] args) {
        maxResult(new int[]{100, -1, -100, -1, 100}, 2);
    }

    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] ints = new int[n];
        ints[0] = nums[0];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty()&&ints[i-1]>ints[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i-1);
            if(queue.peekFirst() <i-k){
                queue.pollFirst();
            }
            ints[i] = ints[queue.peekFirst()] + nums[i];
        }
        return ints[n-1];
    }
}
