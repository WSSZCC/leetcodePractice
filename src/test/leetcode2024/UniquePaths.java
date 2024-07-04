package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 不同路径
 */
public class UniquePaths {
    public static void main(String[] args) {
        uniquePaths(3,3);
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[][] ints = new int[m][n];
        for (int i = 1; i < m; i++) {
            ints[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            ints[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[i][j] = ints[i-1][j]+ints[i][j-1];
            }
        }
        return ints[m-1][n-1];
    }

}
