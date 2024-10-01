package test.leetcode2024;

import java.util.HashSet;
import java.util.Set;

/**
 * 最低票价
 */
public class MincostTickets {
    int[] costs;
    Set<Integer> set;
    Integer[] data;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        this.set = new HashSet<>();
        this.data = new Integer[366];
        for (int day : days) {
            set.add(day);
        }
        return calMinCost(1);
    }

    private int calMinCost(int i) {
        if (i > 365) {
            return 0;
        }
        if (data[i] != null) {
            return data[i];
        }
        if (set.contains(i)) {
            data[i] = Math.min(Math.min(calMinCost(i + 1) + costs[0], calMinCost(i + 7) + costs[1]), calMinCost(i + 30) + costs[2]);
        } else {
            data[i] = calMinCost(i + 1);
        }
        return data[i];
    }
}
