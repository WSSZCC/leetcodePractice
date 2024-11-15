package test.leetcode2024;

/**
 * 最少翻转次数使二进制矩阵回文 I
 */
public class MinFlips {
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int[] ints : grid) {
            int left = 0;
            int right = m-1;
            while (left<right){
                if(ints[left]!=ints[right]){
                    count++;
                }
                left++;
                right--;
            }
        }
        int count1=0;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n-1;
            while (left<right){
                if(grid[left][i]!=grid[right][i]){
                    count1++;
                }
                left++;
                right--;
            }
        }
        return Math.min(count,count1);
    }
}
