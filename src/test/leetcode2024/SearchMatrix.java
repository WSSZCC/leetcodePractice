package test.leetcode2024;

/**
 *  搜索二维矩阵
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(matrix[0][0]>target||matrix[n-1][m-1]<target){
            return false;
        }
        return binarySearch(matrix, target, n, m);
    }

    private boolean binarySearch(int[][] matrix, int target, int n, int m) {
        int len = m * n;
        int left = 1;
        int right = len;
        while (left<=right){
            int mid = left+(right-left)/2;
            int x = mid/ m;
            int y = mid% m -1;
            if(y<0){
                y= m -1;
                x=Math.max(0,x-1);
            }
            if(matrix[x][y]== target){
                return true;
            }
            if(matrix[x][y]> target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}
