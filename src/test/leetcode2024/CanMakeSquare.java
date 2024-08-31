package test.leetcode2024;

/**
 * 构造相同颜色的正方形
 */
public class CanMakeSquare {
    /**
     * @param grid 3x3
     */
    public boolean canMakeSquare(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (checkValue(grid, i, j)) return true;
            }
        }
        return false;
    }

    private boolean checkValue(char[][] grid, int i, int j) {
        int value = grid[i][j] - 'B' + grid[i][j + 1] - 'B' + grid[i + 1][j] - 'B' + grid[i + 1][j + 1] - 'B';
        return value != 2 * ('W' - 'B');
    }
}
