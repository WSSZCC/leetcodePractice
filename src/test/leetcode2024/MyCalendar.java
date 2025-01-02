package test.leetcode2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 我的日程安排表 I
 */
public class MyCalendar {
    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if (list.isEmpty()) {
            list.add(new int[]{startTime, endTime});
            return true;
        }
        boolean isTrue = false;
        if (endTime <= list.get(0)[0] || startTime >= list.get(list.size() - 1)[1]) {
            isTrue = true;
            list.add(new int[]{startTime, endTime});
        }else {
            for (int i = 1; i < list.size(); i++) {
                if (endTime <= list.get(i)[0] && startTime >= list.get(i - 1)[1]) {
                    isTrue = true;
                    list.add(new int[]{startTime,endTime});
                    break;
                }
            }
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        return isTrue;
    }
}
