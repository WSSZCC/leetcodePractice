package test.leetcode2024;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 骑士在棋盘上的概率
 */
public class KnightProbability {
    double usefulSum;
    int[][] ints;

    public double knightProbability(int n, int k, int row, int column) {
        ints = new int[][]{{-2, -2, -1, -1, 1, 1, 2, 2}, {-1, 1, -2, 2, -2, 2, -1, 1}};
        double[][][] ints1 = new double[k + 1][n][n];
        return dfs(ints1,n,k,row,column);
    }

    private double dfs(double[][][] ints1, int n, int k, int x, int y) {
        if(x<0||x>=n||y<0||y>=n){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(ints1[k][x][y]>0){
            return ints1[k][x][y];
        }
        double sum = 0;
        for (int v = 0; v < 8; v++) {
           sum = dfs(ints1,n,k-1,x+ints[0][v],y+ints[1][v]);
        }
        ints1[k][x][y] = sum/8;
        return ints1[k][x][y];
    }

    /**
     * 会超时
     * @return
     */
    public double knightProbability2(int n, int k, int row, int column) {
        double sum = 1.0d;
        for (int i = 0; i < k; i++) {
            sum *= 8.0d;
        }
        ints = new int[][]{{-2, -2, -1, -1, 1, 1, 2, 2}, {-1, 1, -2, 2, -2, 2, -1, 1}};
        usefulSum = 0;
        int[][] ints1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints1[i],0);
        }
        ints1[row][column] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int f = 0; f < n; f++) {
                    if(ints1[j][f]>0){
                        for (int v = 0; v < 8; v++) {
                            int x = j+ints[0][v];
                            int y = f+ints[1][v];
                            if(x<0||x>=n||y<0||y>=n){
                                continue;
                            }
                            ints1[x][y]+=ints1[j][f];
                        }
                    }
                    ints1[j][f] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                usefulSum+=ints1[i][j];
            }
        }
        return usefulSum / sum;
    }

    public double knightProbability1(int n, int k, int row, int column) {
        double sum = 1.0d;
        for (int i = 0; i < k; i++) {
            sum *= 8.0d;
        }
        ints = new int[][]{{-2, -2, -1, -1, 1, 1, 2, 2}, {-1, 1, -2, 2, -2, 2, -1, 1}};
        usefulSum = 0;
        dfs1(0, n, k, row, column);
        return usefulSum / sum;
    }

    private void dfs1(int flag, int n, int k, int row, int column) {
        if (flag == n - 1) {
            usefulSum++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int x = row+ints[0][i];
            int y = column+ints[1][i];
            if(x<0||x>=n||y<0||y>=n){
                continue;
            }
            dfs1(flag+1,n,k,x,y);
        }
    }
}
