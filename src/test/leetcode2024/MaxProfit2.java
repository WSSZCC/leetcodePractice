package test.leetcode2024;

/**
 * 买卖股票的最佳时机 II
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            return Math.max(0,prices[1]-prices[0]);
        }

        int[][] ints1 = new int[2][n];
        ints1[0][0] = -prices[0];
        ints1[1][0] = 0;
        ints1[0][1] = Math.max(-prices[0],-prices[1]);
        ints1[1][1] = Math.max(0,prices[1]-prices[0]);
        for (int i = 2; i < n; i++) {
            ints1[0][i] = Math.max(Math.max(ints1[0][i-1],-prices[i]),ints1[1][i-1]-prices[i]);
            ints1[1][i] = Math.max(Math.max(ints1[0][i-2]+prices[i],ints1[0][i-1]+prices[i]),ints1[1][i-1]);
        }
        return ints1[1][n-1];
    }
}
