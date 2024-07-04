package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 独一无二的出现次数
 */
public class UniqueOccurrences {
    public static void main(String[] args) {

    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer value = map.getOrDefault(i, 0);
            map.put(i, value + 1);
        }
        Set<Integer> collect = new HashSet<>(map.values());
        return map.values().size() == collect.size();
    }
}
