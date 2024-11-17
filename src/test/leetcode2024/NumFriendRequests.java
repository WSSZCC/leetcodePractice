package test.leetcode2024;

import java.util.Arrays;

/**
 * 适龄的朋友
 */
public class NumFriendRequests {
    public static int numFriendRequests(int[] ages) {
        int n = ages.length;
        int count = 0;
        Arrays.sort(ages);
        int preValue = -1;
        int currentCount = 0;
        for (int i = 0; i < n; i++) {
            if (preValue != ages[i]) {
                preValue = ages[i];
                currentCount = getCurrentCount(ages, n, i);
            }
            count += currentCount;
        }
        return count;
    }

    private static int getCurrentCount(int[] ages, int n, int i) {
        int currentCount = 0;
        int v = ages[i] + 14;
        for (int j = 0; j < n; j++) {
            if (ages[j] > ages[i] || (ages[i] < 100 && ages[j] > 100)) {
                break;
            }
            if (i == j || ages[j] * 2 <= v) {
                continue;
            }
            currentCount++;
        }
        return currentCount;
    }
}
