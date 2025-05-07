package test.leetcode2025;

import java.util.*;

/**
 * 到达最后一个房间的最少时间 I
 */
public class MinTimeToReach {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0,4},{4,4}}));
    }
    public static int minTimeToReach(int[][] moveTime) {
        int[][] ints = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] ints1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints1[i], Integer.MAX_VALUE);
        }
        ints1[0][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, 0, 0});
        while (true) {
            int[] poll = queue.poll();
            System.out.println(Arrays.toString(poll));
            int a = poll[0], b = poll[1], c = poll[2];
            if (b == n - 1 && c == m - 1) {
                return a;
            }
            if (a > ints1[b][c]) {
                continue;
            }
            int time = 1;
            for (int i = 0; i < ints.length; i++) {
                int x = ints[i][0] + b;
                int y = ints[i][1] + c;
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                int v = Math.max(a, moveTime[x][y]) + time;
                if(v<ints1[x][y]){
                    ints1[x][y] = v;
                    queue.add(new int[]{v,x,y});
                }
            }
        }
    }
}
