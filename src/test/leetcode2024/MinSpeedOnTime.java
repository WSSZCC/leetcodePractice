package test.leetcode2024;

import java.util.Arrays;

/**
 * 准时到达的列车最小时速
 */
public class MinSpeedOnTime {
    static int lastValue;
    static int maxValue;
    static int[] dist1;
    static int n;

    public static void main(String[] args) {
        minSpeedOnTime(new int[]{6,10,5,1,8,9,2},34.0);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        n = dist.length;
        long round = Math.round(hour * 100);
        long time = round - (n - 1) * 100L;
        if (time <= 0) {
            return -1;
        }
        lastValue = dist[n - 1];
        maxValue = Arrays.stream(dist).max().orElse(0);
        if (round <= n * 100L) {
            return Math.max(maxValue, (int) (((lastValue * 100 - 1) / time) + 1));
        }
        dist1 = dist;
        int l = (int) (round / (n * 100));
        int left = 0;
        int right = (maxValue  - 1) / l + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid,round)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private static boolean check(int v,long round) {
        long t = 0;
        for (int i = 0; i < n-1; i++) {
            t+=(dist1[i]-1)/v+1;
        }
        return (t*v+lastValue)*100<=round*v;
    }
}
