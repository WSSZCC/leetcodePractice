package test.leetcode2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class OrangesRotting {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ints1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ints1[i],-1);
        }
        int[][] ints = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    ints1[i][j] = 0;
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0){
            return -1;
        }
        int ans = 0;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0]+ints[0][i];
                int y = poll[1]+ints[1][i];
                if(x<0||x>m-1||y<0||y>n-1||ints1[x][y]>=0||grid[x][y]==0){
                    continue;
                }
                ints1[x][y] = ints[poll[0]][poll[1]]+1;
                queue.add(new int[]{x,y});
                if(grid[x][y]==1){
                    freshCount--;
                    ans = ints1[x][y];
                    if(freshCount==0){
                        break;
                    }
                }
            }

        }
        return freshCount>0?-1:ans;
    }
}
