package test.leetcode2025;

import java.util.Arrays;

/**
 * 生命游戏
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] ints = new int[][]{{0,0,-1,1,-1,1,-1,1},{1,-1,0,0,-1,1,1,-1}};
        int n = board.length;
        int m = board[0].length;
        int[][] ints1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints1[i],0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    int row = i+ints[0][k];
                    int col = j+ints[1][k];
                    if(row<0||row>=n||col<0||col>=m){
                        continue;
                    }
                    ints1[i][j]+=board[row][col];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ints1[i][j]<2||ints1[i][j]>3){
                    board[i][j] = 0;
                }
                if(ints1[i][j]==3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
