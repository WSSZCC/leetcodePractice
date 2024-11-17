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
                currentCount = 0;
                double v = ages[i] * 0.5 + 7;
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (ages[j] > ages[i]) {
                        break;
                    }
                    if (ages[j] <= v) {
                        continue;
                    }
                    if (ages[i] < 100 && ages[j] > 100) {
                        break;
                    }
                    currentCount++;
                }
            }
            count += currentCount;
        }
        return count;
    }
}
