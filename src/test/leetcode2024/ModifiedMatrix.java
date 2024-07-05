package test.leetcode2024;

/**
 * 修改矩阵
 */
public class ModifiedMatrix {
    public static void main(String[] args) {

    }
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int maxValue = 0;
            for (int[] ints : matrix) {
                maxValue = Math.max(maxValue, ints[i]);
            }
            for (int j = 0; j < m; j++) {
                if(matrix[j][i]==-1){
                    matrix[j][i] = maxValue;
                }
            }

        }
        return matrix;
    }
}
