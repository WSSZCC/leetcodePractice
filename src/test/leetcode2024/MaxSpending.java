package test.leetcode2024;

/**
 * 购买物品的最大开销
 */
public class MaxSpending {
    public long maxSpending(int[][] values) {
        int m = values[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] value : values) {
            max = Math.max(max, value[0]);
            min = Math.min(min, value[m - 1]);
        }
        int[] ints = new int[max - min + 1];
        for (int[] value : values) {
            for (int j = 0; j < m; j++) {
                ints[value[j] - min]++;
            }
        }
        long day =1L;
        long countTime = 0L;
        for (int i = 0; i < ints.length; i++) {
            for (int j = ints[i]; j >0; j--) {
                countTime+=day*(i+min);
                day++;
            }
        }
        return countTime;
    }
}
