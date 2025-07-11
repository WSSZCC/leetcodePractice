package test.leetcode2025;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无需开会的工作日
 */
public class CountDays {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int n = meetings.length;
        int right = meetings[0][1];
        int ans = meetings[0][0] - 1;
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] - right > 1) {
                ans += meetings[i][0] - right - 1;
            }
            right = Math.max(right, meetings[i][1]);

        }

        ans += days - right;

        return ans;
    }
}
