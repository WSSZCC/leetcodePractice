package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 无重叠区间
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int size = list.size();
            int[] ints = list.get(size - 1);
            if(intervals[i][1]<= ints[1]){
                list.remove(size -1);
                list.add(intervals[i]);
            }else if(intervals[i][0]>=ints[1]){
                list.add(intervals[i]);
            }
        }
        return n-list.size();
    }
}
