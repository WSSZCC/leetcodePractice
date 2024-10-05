package test.leetcode2024;

import java.util.Arrays;

/**
 * 完成旅途的最少时间
 */
public class MinimumTime2187 {
    public static void main(String[] args) {
        minimumTime(new int[]{1935,5727103},6189436);
    }
    public static long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        if (n == 1) {
            return (long) totalTrips * time[0];
        }
        Arrays.sort(time);
        int minTime = time[0];
        int maxTime = time[n - 1];
        if(totalTrips==1){
            return minTime;
        }
        int count = totalTrips / n;
        if (totalTrips % n != 0) {
            count++;
        }
        if (minTime == maxTime) {
            return (long) minTime * count;
        }
        long left = (long) minTime * count;
        long right = (long) maxTime * count;
        while (left<=right){
            long mid = left+(right-left)/2;
            if(check(mid,totalTrips,time)){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    private static boolean check(long day, int totalTrips, int[] time) {
        long totalCount = 0;
        for (int i : time) {
            totalCount+=day/i;
            if(totalCount>=totalTrips){
                return false;
            }
        }
        return true;
    }
}
