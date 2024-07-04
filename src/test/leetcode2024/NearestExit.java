package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 迷宫中离入口最近的出口
 */
public class NearestExit {
    public static void main(String[] args) {
        char[][] chars = {
                {'+', '+', '.', '+', '+'},
                {'+', '+', '.', '.', '+'},
                {'.', '.', '.', '.', '+'},
                {'+', '+', '+', '.', '+'},
                {'+', '+', '+', '+', '+'}};
        nearestExit(chars, new int[]{2, 3});
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ints = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + ints[0][i];
                int y = poll[1] + ints[1][i];
                if (x >= 0 && y >= 0 && x <= n - 1 && y <= m - 1 && maze[x][y] == '.') {
                    if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                        return poll[2] + 1;
                    }
                    queue.add(new int[]{x, y, poll[2] + 1});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }

    public int nearestExit1(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int count = 1;
        if (entrance[0] != 0) {
            count = Math.min(bfs(n, m, maze, entrance[0] - 1, entrance[1], 0), count);//向上
        }
        if (entrance[0] != n - 1) {
            count = Math.min(bfs(n, m, maze, entrance[0] + 1, entrance[1], 0), count);//向下
        }
        if (entrance[1] != 0) {
            count = Math.min(bfs(n, m, maze, entrance[0], entrance[1] - 1, 0), count);//向左
        }
        if (entrance[1] != m - 1) {
            count = Math.min(bfs(n, m, maze, entrance[0], entrance[1] + 1, 0), count);//向右
        }
        return count == 0 ? -1 : count;
    }

    private int bfs(int n, int m, char[][] maze, int l, int r, int count) {
        if (maze[l][r] != '.') {
            return -1;
        }
        count++;
        if (l == 0 || l == n - 1 || r == 0 || r == m - 1) {
            return count + 1;
        }
        bfs(n, m, maze, l - 1, r, count);//向上
        bfs(n, m, maze, l + 1, r, count);//向上
        bfs(n, m, maze, l, r - 1, count);//向上
        bfs(n, m, maze, l, r + 1, count);//向上
        return count;
    }
}
