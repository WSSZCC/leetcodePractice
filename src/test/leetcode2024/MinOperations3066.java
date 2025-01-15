package test.leetcode2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 超过阈值的最少操作数 II
 */
public class MinOperations3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num : nums) {
            if(num<k){
                queue.add(num);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            Integer a = queue.poll();
            Integer b = queue.poll();
            if(b!=null){
               long v = 2L *a+b;
               if(v<k){
                   queue.add(2*a+b);
               }
            }
            count++;
        }
        return count;
    }
}
