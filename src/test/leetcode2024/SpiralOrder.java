package test.leetcode2024;

import java.util.*;

/**
 * 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] booleans = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i], false);
        }
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        booleans[0][0] = true;
        int[] ints = {1, 1, -1, -1};
        int i = 0;
        int j = 0;
        int flag = 0;
        boolean isTrue = false;
        int count = 0;
        while (true) {
            if (!booleans[i][j]) {
                list.add(matrix[i][j]);
                booleans[i][j] = true;
            }
            if(isTrue){
                count++;
            }
            if (flag == 2 || flag == 0) {
                j += ints[flag];
                if (j < 0 || j > n - 1 || booleans[i][j]) {
                    j -= ints[flag];
                    flag++;
                    flag = flag % 4;
                    isTrue = true;
                } else {
                    isTrue = false;
                    count=0;
                }
            } else {
                i += ints[flag];
                if (i < 0 || i > n - 1 || booleans[i][j]) {
                    i -= ints[flag];
                    flag++;
                    flag = flag % 4;
                    isTrue = true;
                } else {
                    isTrue = false;
                    count=0;
                }
            }
            if(count>1){
                break;
            }
        }
        return list;
    }
}
