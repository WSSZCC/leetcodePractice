package test.leetcode2024;

/**
 * 购买水果需要的最少金币数
 */
public class MinimumCoins {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        for (int i = (n + 1) / 2 - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < 2 * i + 1; j++) {
                min = Math.min(min, prices[j]);
            }
            prices[i - 1] += min;
        }
        return prices[0];
    }
}
