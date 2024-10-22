package test.leetcode2024;

import java.util.Arrays;

/**
 * 构成整天的下标对数目 I
 */
public class CountCompleteDayPairs {
    public int countCompleteDayPairs(int[] hours) {
        int count=0;
        int day=24;
        int[] ints = new int[day];
        Arrays.fill(ints,0);
        for(int hour :hours){
            int time =hour%day;
            count+=ints[(day-time)%day];
            ints[time]++;
        }
        return count;
    }
}
