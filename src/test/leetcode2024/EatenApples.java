package test.leetcode2024;

import java.util.PriorityQueue;

/**
 * 吃苹果的最大数目
 */
public class EatenApples {
    public static void main(String[] args) {
//        System.out.println(eatenApples(new int[]{1,10,17,10,12,6,20,8,8,22,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,5,2,1,0,0,0,0,0,0,23},
//                new int[]{19999,11,18,22,5,2,14,5,20,7,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,2,1,4,2,7,0,0,0,0,0,0,1}));
        System.out.println(eatenApples(new int[]{1,2,3,5,2},new int[]{3,2,1,4,2}));
    }
    public static int eatenApples(int[] apples, int[] days) {
        int count = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int n = apples.length;
        for (int i = 0; i < n||!queue.isEmpty(); i++) {
            if((i<n&&apples[i]==0)&&queue.isEmpty()){
                continue;
            }
            if(i>=n&&queue.size()==1){
                count+=Math.min(queue.peek()[1]-i,queue.peek()[0]);
                break;
            }
            if(i<n&&apples[i]!=0){
                queue.add(new int[]{apples[i],days[i]+i});
            }
            int[] poll = queue.poll();
            queue.add(new int[]{poll[0]-1,poll[1]});
            while (!queue.isEmpty()&&(queue.peek()[0]<=0||queue.peek()[1]==i+1)){
                queue.poll();
            }
            count++;
        }
        return count;
    }
}
