package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxValue = 0;
        for (int i = 0; i < candies.length; i++) {
            if (maxValue < candies[i]) {
                maxValue = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    /**
     * @param candies
     * @param extraCandies
     * @return 内存更小的版本
     */
    private static List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            maxValue = Math.max(maxValue, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= maxValue);
        }
        return list;
    }
}
