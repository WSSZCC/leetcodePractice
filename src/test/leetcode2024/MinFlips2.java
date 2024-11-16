package test.leetcode2024;

/**
 * 最少翻转次数使二进制矩阵回文 II
 */
public class MinFlips2 {
    public static void main(String[] args) {
        minFlips(new int[][]{{1,0,1,0,1}});
    }
    public static int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left < right) {
            int left1 = 0;
            int right1 = m - 1;
            while (left1 < right1) {
                int value = grid[left][left1] + grid[left][right1] + grid[right][left1] + grid[right][right1];
                if (value == 3 || value == 1) {
                    count++;
                }
                if (value == 2) {
                    count += 2;
                }
                left1++;
                right1--;
            }
            left++;
            right--;
        }
        int i = 0;
        int j = 0;
        int x = (n - 1) / 2;
        int y = (m - 1) / 2;
        if (m % 2 == 1 && n % 2 == 1) {
            count += grid[x][y];
        }
        if (n % 2 == 1) {
            left = 0;
            right = m - 1;
            while (left < right) {
                if (grid[x][left] == grid[x][right]) {
                    i += grid[x][left]*2;
                } else {
                    j++;
                }
                left++;
                right--;
            }
        }
        if (m % 2 == 1) {
            left = 0;
            right = n - 1;
            while (left < right) {
                if (grid[left][y] == grid[right][y]) {
                    i+=grid[left][y]*2;
                } else {
                    j++;
                }
                left++;
                right--;
            }
        }
        // 当j的长度大于1是，可以不用考虑i的值，因为如果i可以被4整除，我们可以将j全转换为0，如果i不能被4整除，i必余2，我们只需要用j补上缺失的2即可
        if(j>0){
            count+=j;
        }else {
            count+=i%4;
        }
        return count;
    }
}
