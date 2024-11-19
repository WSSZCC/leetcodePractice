package test.leetcode2024;

import java.util.ArrayList;

/**
 * 新增道路查询后的最短距离 I
 */
public class ShortestDistanceAfterQueries {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        ArrayList<Integer>[] lists = new ArrayList[n];
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
            lists[i] = new ArrayList<>();
        }
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int v1 = queries[i][0];
            int v2 = queries[i][1];
            lists[i].add(v1);
            if (ints[v1] + 1 < ints[v2]) {
                ints[v2] = ints[v1] + 1;
                for (int j = v2; j < n; j++) {
                    ints[j] = Math.min(ints[j], ints[j - 1] + 1);
                    for (Integer integer : lists[i]) {
                        ints[j] = Math.min(ints[j], ints[integer] + 1);
                    }
                }
            }
            ans[i] = ints[n - 1];
        }
        return ans;
    }
}
