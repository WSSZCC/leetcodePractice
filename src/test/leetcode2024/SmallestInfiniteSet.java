package test.leetcode2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 无限集中的最小数字
 */
public class SmallestInfiniteSet {
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
       queue = new PriorityQueue<>(Comparator.comparingInt(a->a));
        for (int i = 1;i<=1000;i++){
            queue.add(i);
        }
    }

    public int popSmallest() {
        if(!queue.isEmpty()){
            return queue.poll();
        }
        return 1;
    }

    public void addBack(int num) {
        if(!queue.contains(num)){
            queue.add(num);
        }

    }
}
