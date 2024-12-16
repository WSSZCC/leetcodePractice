package test.leetcode2024;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 岛屿数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] ints = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        boolean[][] booleans = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i],false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!booleans[i][j]&&grid[i][j]=='1'){
                    LinkedList<int[]> list = new LinkedList<>();
                    list.add(new int[]{i,j});
                    booleans[i][j]=true;
                    while (!list.isEmpty()){
                        int[] poll = list.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = poll[0]+ints[0][k];
                            int y = poll[1]+ints[1][k];
                            if(x<0||y<0||x>=n||y>=m||booleans[x][y]||grid[x][y]=='0'){
                                continue;
                            }
                            booleans[x][y] = true;
                            list.add(new int[]{x,y});
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
