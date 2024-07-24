package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 重新放置石块
 */
public class RelocateMarbles {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
       Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return set.stream().sorted().collect(Collectors.toList());
    }
}
