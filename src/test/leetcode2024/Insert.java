package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isTrue = false;
        for (int[] interval : intervals) {
            if (interval[1] >= newInterval[0] && interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                if (isTrue) {
                    list.set(list.size() - 1, newInterval);
                } else {
                    isTrue = true;
                    list.add(newInterval);
                }
            } else {
                list.add(interval);
            }
        }
        if(!isTrue){
            list.add(newInterval);
        }
        int[][] ints = list.toArray(new int[list.size()][]);
        Arrays.sort(ints, Comparator.comparingInt(a->a[0]));
        return ints;
    }
}
