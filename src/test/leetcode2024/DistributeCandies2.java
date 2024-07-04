package test.leetcode2024;

/**
 * 分糖果 II
 */
public class DistributeCandies2 {
    public static void main(String[] args) {
        distributeCandies(114,4);
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] ints = new int[num_people];
        int k = 0;
        int value = 1;
        while (candies > 0) {
            if (candies - value < 0) {
                value = candies;

            }
            candies -= value;
            if (k == num_people) {
                k = 0;
            }
            ints[k] += value;
            value++;
            k++;
        }
        return ints;

    }
}
