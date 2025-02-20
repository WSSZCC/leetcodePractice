package test.leetcode2025;

import java.util.List;

/**
 * 数组列表中的最大距离
 */
public class MaxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = 10001;
        int max = -10001;
        int ans = 0;
        for (List<Integer> array : arrays) {
            ans = Math.max(ans, Math.max(max - array.get(0), array.get(array.size() - 1) - min));
            min = Math.min(array.get(0), min);
            max = Math.max(array.get(array.size() - 1), max);
        }
        return ans;
    }
}
