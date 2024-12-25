package test.leetcode2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 切蛋糕的最小总开销 I
 */
public class MinimumCost {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int h = 1;
        int v = 1;
        int cost = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->-a[0]));
        for (int i : horizontalCut) {
            queue.add(new int[]{i,0});
        }
        for (int i : verticalCut) {
            queue.add(new int[]{i,1});
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[1]==0){
                h++;
                cost+=v*poll[0];
            }else {
                v++;
                cost+=h*poll[0];
            }
        }
        return cost;
    }
}
