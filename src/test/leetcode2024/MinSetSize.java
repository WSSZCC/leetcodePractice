package test.leetcode2024;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 数组大小减半
 */
public class MinSetSize {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i,orDefault+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        queue.addAll(map.values());
        int count = 0;
        int value = arr.length/2;
        while (!queue.isEmpty()){
            count++;
            value -= queue.poll();
            if(value<=0){
                break;
            }
        }
        return count;
    }
}
