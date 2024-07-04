package test.leetcode2024;

import java.util.*;

/**
 * 重新规划路线
 */
public class MinReorder {

    public static void main(String[] args) {
        minReorder(6, new int[][]{{0, 2}, {0, 3}, {4, 1}, {4, 5}, {5, 0}});
    }


    public static int minReorder(int n, int[][] connections) {
        boolean[] booleans = new boolean[n - 1];
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int k = connections.length;
        Arrays.sort(connections,Comparator.comparingInt(a->a[0]));
        int minReorder = 0;
        int flag=0;
        while (k > 0) {
            for (int i = flag; i < connections.length; i++) {
                if (booleans[i]) {
                    continue;
                }
                boolean b1 = set.contains(connections[i][0]);
                boolean b2 = set.contains(connections[i][1]);
                if (b1 || b2) {
                    if (b2) {
                        set.add(connections[i][0]);
                    } else {
                        set.add(connections[i][1]);
                        minReorder++;
                    }
                    booleans[i] = true;
                    k--;
                }
            }
        }
        return minReorder;
    }
}
