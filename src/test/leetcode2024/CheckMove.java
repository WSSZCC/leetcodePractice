package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  检查操作是否合法
 */
public class CheckMove {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        int m = board[0].length;
        int[][] ints = {{-1, -1, -1, 0, 0, 1, 1, 1}, {0, -1, 1, -1, 1, -1, 0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < ints[0].length; i++) {
            int x = ints[1][i]+rMove;
            int y = ints[0][i]+cMove;
            if(x<0||x>=n||y<0||y>=m){
                continue;
            }
            if(board[x][y]!='.'&&board[x][y]!=color){
                queue.add(new int[]{x,y,ints[1][i],ints[0][i]});
            }
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0]+poll[2];
            int y = poll[1]+poll[3];
            if(x<0||x>=n||y<0||y>=m){
                continue;
            }
            if(board[x][y]==color){
                return true;
            }
            if(board[x][y]!='.'&&board[x][y]!=color){
                queue.add(new int[]{x,y,poll[2],poll[3]});
            }
        }
        return false;
    }
}
