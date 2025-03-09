package test.leetcode2025;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每一个查询的最大美丽值
 */
public class MaximumBeauty {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int n = queries.length;
        int m = items.length;
        int[] ints = new int[n];
        Integer[] ints1 = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints1[i] = i;
        }
        Arrays.sort(ints1, Comparator.comparingInt(a -> queries[a]));
        Arrays.fill(ints, 0);
        int value = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int query = queries[ints1[i]];
            // 获取小于queries[i]的最大美丽数
            while (index < m && items[index][0] <= query) {
                value = Math.max(value, items[index][1]);
                index++;
            }
            ints[ints1[i]] = value;
        }
        return ints;
    }
}
