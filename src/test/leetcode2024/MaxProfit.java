package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 买卖股票的最佳时机含手续费
 */
public class MaxProfit {
    public static void main(String[] args) {
        maxProfit(new int[]{1,3, 2, 8, 4, 9},2);
    }

    /**
     * @param prices  写昏头了，不知道怎么写出来了
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            return Math.max(0,prices[1]-prices[0]-fee);
        }

        int[][] ints1 = new int[2][n];
        ints1[0][0] = -prices[0];
        ints1[1][0] = 0;
        ints1[0][1] = Math.max(-prices[0],-prices[1]);
        ints1[1][1] = Math.max(0,prices[1]-prices[0]-fee);
        for (int i = 2; i < n; i++) {
            ints1[0][i] = Math.max(Math.max(ints1[0][i-1],-prices[i]),ints1[1][i-1]-prices[i]);
            ints1[1][i] = Math.max(Math.max(ints1[0][i-2]+prices[i]-fee,ints1[0][i-1]+prices[i]-fee),ints1[1][i-1]);
        }
        return ints1[1][n-1];
    }

    /**
     * @param prices 暴力法。唯一的问题会超时
     * @param fee
     * @return
     */
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            return Math.max(0,prices[1]-prices[0]-fee);
        }
        long[][] ints = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    ints[i][j] = Math.max(-prices[i] - fee + prices[j],0);
                }
            }
        }
        for(int i = n-3;i>=0;i--){
            for (int j = n-1;j>i;j--){
                if(j==n-1){
                    ints[i][j] = Math.max(ints[i][j],ints[i+1][j]);
                }else if(j==n-2){
                    ints[i][j] = Math.max(Math.max(ints[i][j+1],ints[i][j]),ints[i+1][j+1]);
                }else {
                    ints[i][j] = Math.max(Math.max(ints[i][j]+ints[j+1][j+2],ints[i][j+1]),ints[i+1][j+1]);
                }
            }
        }
        return  (int) ints[0][1];
    }
}
