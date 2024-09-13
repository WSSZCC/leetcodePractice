package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  合并区间
 */
public class Merge {
    public  int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> list = genList(intervals, n);
        return list.toArray(new int[list.size()][]);
    }

    private  List<int[]> genList(int[][] intervals, int n) {
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(intervals[i][0]>right){
                list.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                right = Math.max(right, intervals[i][1]);
            }
            if(i== n -1){
                list.add(new int[]{left,right});
            }
        }
        return list;
    }
}
