package test.leetcode2024;

import java.util.*;

/**
 * 网络延迟时间
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int flag = Integer.MAX_VALUE / 2;
        int[][] ints = new int[n][n];
        for (int[] anInt : ints) {
            Arrays.fill(anInt, flag);
        }
        for (int[] time : times) {
            ints[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] ints1 = new int[n];
        Arrays.fill(ints1, flag);
        boolean[] booleans = new boolean[n];
        ints1[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!booleans[y] && (x == -1 || ints1[y] < ints1[x])) {
                    x = y;
                }
            }
            booleans[x] = true;
            for (int j = 0; j < n; j++) {
                ints1[j] = Math.min(ints1[j], ints1[x] + ints[x][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, ints1[i]);
        }
        return ans == flag ? -1 : ans;
    }

    /**
     * 只能过一部分用列
     *
     * @return
     */
    public int networkDelayTime1(int[][] times, int n, int k) {
        Set<Integer> set = new HashSet<>();
        int[] ints = new int[n + 1];
        Arrays.fill(ints, Integer.MAX_VALUE);
        ints[k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[] booleans = new boolean[times.length];
        Arrays.fill(booleans, false);
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] == k) {
                queue.add(times[i]);
                ints[times[i][1]] = times[i][2];
                booleans[i] = true;
            }
        }
        for (int[] time : times) {
            if (time[0] == k) {
                queue.add(time);
                set.add(time[0]);
                ints[time[1]] = time[2];
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < times.length; i++) {
                if (!booleans[i] && poll[1] == times[i][0]) {
                    ints[times[i][1]] = set.contains(times[i][1]) ?
                            Math.min(ints[times[i][1]], ints[poll[1]] + times[i][2]) : poll[2] + times[i][2];
                    set.add(times[i][1]);
                    int[] ints1 = {times[i][0], times[i][1], ints[times[i][1]]};
                    queue.add(ints1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < ints.length; i++) {
            ans = Math.max(ans, ints[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
