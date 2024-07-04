package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 钥匙和房间
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (rooms.get(0).isEmpty()) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Set<Integer> set1 = new HashSet<>(rooms.get(0));
        while (true) {
            Set<Integer> set2 = new HashSet<>();
            for (Integer integer : set1) {
                if (!set.contains(integer)) {
                    set2.addAll(rooms.get(integer));
                    set.add(integer);
                }
            }
            if (set1.isEmpty()) {
                break;
            }
            set1.clear();
            set1.addAll(set2);
        }
        return set.size() == n;
    }
}
