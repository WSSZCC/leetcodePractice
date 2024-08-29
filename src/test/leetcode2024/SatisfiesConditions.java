package test.leetcode2024;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断矩阵是否满足条件
 */
public class SatisfiesConditions {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ints = {{0, 1, -1}, {1, 0, 0}};
        boolean[][] booleans = initBooleans(n, m);
        booleans[0][0] = true;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] anInt : ints) {
                int x = poll[0] + anInt[0];
                int y = poll[1] + anInt[1];
                if (x >= n || y >= m || booleans[x][y]) {
                    continue;
                }
                booleans[x][y] = true;
                if (validGridValue(grid, poll, anInt, x, y)) return false;
                queue.add(new int[]{x, y});
            }
        }
        return true;
    }

    private boolean[][] initBooleans(int n, int m) {
        boolean[][] booleans = new boolean[n][m];
        for (boolean[] aBoolean : booleans) {
            Arrays.fill(aBoolean, false);
        }
        return booleans;
    }

    private boolean validGridValue(int[][] grid, int[] poll, int[] anInt, int x, int y) {
        if (anInt[2] == -1) {
            return grid[poll[0]][poll[1]] == grid[x][y];
        } else {
            return grid[poll[0]][poll[1]] != grid[x][y];
        }
    }
}
