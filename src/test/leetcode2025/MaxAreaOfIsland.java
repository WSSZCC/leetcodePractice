package test.leetcode2025;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        boolean[][] booleans = new boolean[n][m];
        int[][] ints = { { 1, -1, 0, 0 }, { 0, 0, 1, -1 } };
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!booleans[i][j] && grid[i][j] == 1) {
                    int count = 1;
                    booleans[i][j] = true;
                    LinkedList<int[]> list = new LinkedList<>();
                    list.add(new int[] { i, j });
                    while (!list.isEmpty()) {
                        int[] ints1 = list.poll();
                        for (int k = 0; k < 4; k++) {
                            int row = ints[0][k] + ints1[0];
                            int col = ints[1][k] + ints1[1];
                            if (row < 0 || row >= n || col < 0 || col >= m || booleans[row][col]
                                    || grid[row][col] == 0) {
                                continue;
                            }
                            count++;
                            list.add(new int[] { row, col });
                            booleans[row][col] = true;
                        }
                    }
                    total = Math.max(total, count);
                }
            }
        }
        return total;
    }

}
