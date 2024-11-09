package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计相邻元素求和服务
 */
public class NeighborSum {
    private int[][] grid;
    private Map<Integer,int[]> map;

    public NeighborSum(int[][] grid) {
        int n = grid.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v1 = grid[i][j];
                int v2 = grid[i][j];
                if(i-1>=0){
                    if(j-1>=0){
                        v2+=grid[i-1][j-1];
                    }
                    if(j+1<n){
                        v2+=grid[i-1][j+1];
                    }
                    v1+=grid[i-1][j];
                }
                if(i+1<n){
                    if(j-1>=0){
                        v2+=grid[i+1][j-1];
                    }
                    if(j+1<n){
                        v2+=grid[i+1][j+1];
                    }
                    v1+=grid[i+1][j];
                }
                if(j-1>=0){
                    v1+=grid[i][j-1];
                }
                if(j+1<n){
                    v1+=grid[i][j+1];
                }
                map.put(grid[i][j],new int[]{v1,v2});
            }
        }
    }

    public int adjacentSum(int value) {
        return map.get(value)[0];
    }

    public int diagonalSum(int value) {
        return map.get(value)[1];
    }
}
