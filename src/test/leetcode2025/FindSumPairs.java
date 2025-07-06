package test.leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出和为指定值的下标对
 */
public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int j : nums2) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

    }

    public void add(int index, int val) {
        int pre = nums2[index];
        nums2[index] += val;
        if (map.get(pre) == 1) {
            map.remove(pre);
        } else {
            map.put(pre, map.get(pre) - 1);
        }
        map.put(nums2[index], map.getOrDefault( nums2[index], 0) + 1);

    }

    public int count(int tot) {
        int ans = 0;
        for (int i : nums1) {
            ans+=map.getOrDefault( tot-i, 0);
        }
        return ans;
    }
}
