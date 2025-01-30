package test.leetcode2024;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 两个数组的交集 II
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            Integer orDefault = map.getOrDefault(j, 0);
            map.put(j, orDefault + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)&&map.get(i)>0){
                map.put(i,map.get(i)-1);
                list.add(i);
            }
        }
        int n = list.size();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
