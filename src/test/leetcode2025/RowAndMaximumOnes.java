package test.leetcode2025;

/**
 * 一最多的行
 */
public class RowAndMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int row = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = 0; j < m; j++) {
                value+=mat[i][j];
            }
            if(value>ans){
                row = i;
                ans = value;
            }
        }
        return new int[]{row,ans};

    }
}
