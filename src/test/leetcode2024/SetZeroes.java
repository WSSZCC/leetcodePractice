package test.leetcode2024;

import java.util.*;

/**
 * 矩阵置零
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int next : rowSet) {
            Arrays.fill(matrix[next], 0);
        }
        for (Integer integer : colSet) {
            for (int i = 0; i < n; i++) {
                matrix[i][integer] = 0;
            }
        }

    }
}
