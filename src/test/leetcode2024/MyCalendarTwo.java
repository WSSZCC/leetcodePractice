package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的日程安排表 II
 */
public class MyCalendarTwo {
    List<int[]> list;
    List<int[]> list1;

    public MyCalendarTwo() {
        list = new ArrayList<>();
        list1 = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] ints : list1) {
            int a = ints[0];
            int b = ints[1];
            if (a < endTime && b > startTime) {
                return false;
            }
        }
        for (int[] ints : list) {
            int a = ints[0];
            int b = ints[1];
            if (a < endTime && b > startTime) {
                list1.add(new int[]{Math.max(a, startTime), Math.min(b, endTime)});
            }
        }
        list.add(new int[]{startTime, endTime});
        return true;
    }
}
