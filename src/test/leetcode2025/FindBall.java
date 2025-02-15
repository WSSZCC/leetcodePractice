package test.leetcode2025;

/**
 * 球会落何处
 */
public class FindBall {

    public int[] findBall(int[][] grid) {
        int m = grid[0].length;
        int[] ints = new int[m];
        for (int i = 0; i < m; i++) {
            int y = i;
            for (int[] value : grid) {
                if (y == 0 && value[y] == -1 || y == m - 1 && value[y] == 1 || value[y] != value[y + value[y]]) {
                    y = -1;
                    break;
                }
                y += value[y];
            }
            ints[i] = y;
        }
        return ints;
    }
}
