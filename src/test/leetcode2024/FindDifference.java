package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 找出两数组的不同
 */
public class FindDifference {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                set2.remove(integer);
            } else {
                list1.add(integer);
            }
        }
        List<Integer> list2 = new ArrayList<>(set2);
        res.add(list1);
        res.add(list2);
        return res;
    }
}
