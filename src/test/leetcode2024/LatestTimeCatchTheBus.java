package test.leetcode2024;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 坐上公交的最晚时间
 */
public class LatestTimeCatchTheBus {
    public static void main(String[] args) {
        latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2);
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int time = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int bus : buses) {
            int size = set.size();
            if (size >= m) {
                return buses[n - 1];
            }
            time = getTime(passengers, capacity, m, time, set, bus);
        }
        time = calMaxTime(passengers, time, set);
        return time;
    }

    private static int calMaxTime(int[] passengers, int time, HashSet<Integer> set) {
        int size = set.size() - 1;
        if (set.contains(time)) {
            time = 1;
        }
        while (size >= 0) {
            int passenger = passengers[size];
            if (!set.contains(passenger - 1)) {
                time = Math.max(passenger - 1, time);
                break;
            }
            size--;
        }
        return time;
    }

    private static int getTime(int[] passengers, int capacity, int m, int time, HashSet<Integer> set, int bus) {
        int flag = capacity;
        while (flag > 0) {
            if (set.size() >= m || passengers[set.size()] > bus) {
                time = bus;
                break;
            }
            set.add(passengers[set.size()]);
            flag--;
        }
        return time;
    }
}
