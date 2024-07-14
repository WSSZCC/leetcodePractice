package test.leetcode2024;

/**
 *  保持城市天际线
 */
public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
    }
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowInts = new int[n];
        int[] colInts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colInts[i] = Math.max(colInts[i],grid[i][j]);
                rowInts[j] = Math.max(rowInts[j],grid[i][j]);
            }
        }
        int height = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                height+=Math.min(colInts[i],rowInts[j])-grid[i][j];
            }
        }
        return height;
    }
}
