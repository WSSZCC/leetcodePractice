package test.leetcode2024;

import java.util.Arrays;

/**
 * 在既定时间做作业的学生人数
 */
public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (check(startTime, endTime, queryTime, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(int[] startTime, int[] endTime, int queryTime, int i) {
        return startTime[i] <= queryTime && endTime[i] >= queryTime;
    }

    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > maxEndTime) {
            return 0;
        }
        int[] ints = new int[maxEndTime + 2];
        for (int i = 0; i < n; i++) {
            ints[startTime[i]]++;
            ints[endTime[i] + 1]--;
        }
        int count = 0;
        for (int i = 0; i <= queryTime; i++) {
            count += ints[i];
        }
        return count;
    }
}
