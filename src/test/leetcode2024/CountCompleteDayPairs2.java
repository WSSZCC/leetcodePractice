package test.leetcode2024;

import java.util.Arrays;

/**
 *  构成整天的下标对数目 II
 */
public class CountCompleteDayPairs2 {
    public long countCompleteDayPairs(int[] hours) {
        long count=0;
        int day=24;
        long[] ints = new long[day];
        Arrays.fill(ints,0);
        for(int hour :hours){
            int time =hour%day;
            count+=ints[(day-time)%day];
            ints[time]++;
        }
        return count;
    }
}
