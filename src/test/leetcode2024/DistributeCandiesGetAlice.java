package test.leetcode2024;

import java.util.HashSet;
import java.util.Set;

/**
 * 分糖果
 */
public class DistributeCandiesGetAlice {
    public static void main(String[] args) {

    }

    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int j : candyType) {
            set.add(j);
        }

        int maxEatCount = n/2;
        return Math.min(set.size(), maxEatCount);
    }
}
