package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 找到两个数组中的公共元素
 */
public class FindIntersectionValues {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] ints = new int[]{0,0};
        for (int i : nums1) {
            Integer orDefault = map1.getOrDefault(i, 0);
            map1.put(i,orDefault+1);
        }
        for (int i : nums2) {
            Integer orDefault = map2.getOrDefault(i, 0);
            map2.put(i,orDefault);
            if(map1.containsKey(i)){
                ints[0] += map1.get(i);
                map1.remove(i);
            }
        }
        for (int i : nums1) {
            if(map2.containsKey(i)){
               ints[1] += map2.get(i);
               map2.remove(i);
            }
        }
        return ints;
    }
}
