package test.leetcode2024;

import java.util.Scanner;

/**
 * 605. 种花问题
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k = flowerbed.length;
        int i = 0;
        while (i < k) {
            if (flowerbed[i] == 1) {
                i = i + 2;
            } else {
                if (i + 1 == k || flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    i = i + 2;
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;

    }

}
