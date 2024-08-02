package test.leetcode2024;

import java.util.HashMap;

/**
 * 直角三角形
 */
public class NumberOfRightTriangles {
    public static void main(String[] args) {
        numberOfRightTriangles(new int[][]{{0,1,1},{0,1,0},{0,1,0}});
    }
    public static long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashMap<Integer, Integer> colMap = new HashMap<>();
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    Integer rowCount = rowMap.getOrDefault(i, 0);
                    rowMap.put(i,rowCount+1);
                    Integer colCount = colMap.getOrDefault(j, 0);
                    colMap.put(j,colCount+1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    if(colMap.containsKey(j)&&rowMap.containsKey(i)){
                        ans+=(rowMap.get(i)-1)*(colMap.get(j)-1);
                    }
                }
            }
        }
        return ans;
    }
}
