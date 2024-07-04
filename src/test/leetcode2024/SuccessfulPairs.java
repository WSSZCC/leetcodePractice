package test.leetcode2024;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数
 */
public class SuccessfulPairs {
    public static void main(String[] args) {
        successfulPairs(new int[]{5,1,3},new int[]{1,2,3,4,5},7);
    }

    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            pairs[i] = successful(spells[i], potions, success);
        }
        return pairs;
    }

    private static int successful(int i, int[] potions, long success) {
        int n = potions.length;
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if ((long) i * potions[index] >= success) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return n - left;
    }

    private static int guess(long n, long success) {
        return Long.compare(success, n);
    }


}
