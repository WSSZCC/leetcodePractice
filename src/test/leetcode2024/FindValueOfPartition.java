package test.leetcode2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找出分区值
 */
public class FindValueOfPartition {
    public int findValueOfPartition(int[] nums) {
        if(nums.length<2){
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a->-a));
        for (int num : nums) {
            queue.add(num);
        }
        Integer num1 = queue.poll();
        Integer num2 = queue.poll();
        int minNum = num2-num1;
        while (!queue.isEmpty()){
            num1 = num2;
            num2 = queue.poll();
            minNum = Math.min(minNum,num2-num1);
            if(minNum==0){
                return minNum;
            }
        }
        return minNum;
    }
}
