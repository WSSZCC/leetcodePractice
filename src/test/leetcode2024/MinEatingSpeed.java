package test.leetcode2024;

import java.util.Arrays;

/**
 * 爱吃香蕉的珂珂
 */
public class MinEatingSpeed {
    public static void main(String[] args) {
        minEatingSpeed(new int[]{312884470}, 312884469);
//        minEatingSpeed(new int[]{3,6,7,11}, 8);
//        minEatingSpeed(new int[]{30,11,23,4,20}, 6);
//        minEatingSpeed(new int[]{312884470}, 968709470);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxVale = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        int right = maxVale;
        while (left < right) {
            int speed = left + (right - left) / 2;
            long hour = getHour(piles, speed);
            if (h >= hour) {
                right = speed;
            } else {
                left = speed+1;
            }
        }
        return right;
    }

    public static long getHour(int[] piles, int speed) {
        long hour = 0;
        for (int pile : piles) {
            long time = pile / speed;
            if (pile % speed > 0) {
                time++;
            }
            hour += time;
        }
        return hour;
    }
}
