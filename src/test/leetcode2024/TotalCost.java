package test.leetcode2024;

import java.util.*;

/**
 * 雇佣 K 位工人的总代价
 */
public class TotalCost {
    public static void main(String[] args) {
        totalCost(new int[]{42,28,56,5,53,35,88,77,1,66,57,41,50,27,52,70,67,60,65,99,49,84,82,31,45,94,62,45,32,71,61,61,61,23,47,34}, 11, 3);
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        long cost = 0;
        int n = costs.length;
        if (n == candidates) {
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{costs[i], i});
            }
            for (int i = 0; i < k; i++) {
                if (!queue.isEmpty()) {
                    cost += queue.poll()[0];
                }
            }
            return cost;
        }
        int leftOffset = 0;
        int rightOffset = 0;
        for (int i = 0; i < candidates; i++) {
            queue.add(new int[]{costs[i], i});
        }
        for (int i = n-candidates; i < n; i++) {
            queue.add(new int[]{costs[i], i});
        }
        if(n>=2*(Math.max(k,candidates))){
            for (int i = 0; i < k; i++) {
                int[] poll = queue.poll();
                cost+=poll[0];
                if(poll[1]>=n-candidates-rightOffset){
                    rightOffset++;
                    queue.add(new int[]{costs[n-candidates-rightOffset],n-candidates-rightOffset});
                }else {
                    leftOffset++;
                    queue.add(new int[]{costs[candidates-1+leftOffset],candidates-1+leftOffset});
                }
            }
            return cost;
        }
        int flag = n-2*candidates;
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            if(!queue.isEmpty()&&queue.peek()[1]==poll[1]){
                queue.poll();
            }
            cost+=poll[0];
            if(flag>0){
                if(poll[1]>n-candidates-rightOffset){
                    rightOffset++;
                    queue.add(new int[]{costs[n-candidates-rightOffset],n-candidates-rightOffset});
                }else {
                    leftOffset++;
                    queue.add(new int[]{costs[candidates-1+leftOffset],candidates-1+leftOffset});
                }
                flag--;
            }
        }
        return cost;
    }
}
