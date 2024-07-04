package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 相等行列对
 */
public class EqualPairs {
    public static void main(String[] args) {
        equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}});
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        List<List<Integer>> acrossList = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> list1 = new ArrayList<>();
            for (int data : ints) {
                list1.add(data);
            }
            acrossList.add(list1);
        }
        List<List<Integer>> lengthwaysList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int[] ints : grid) {
                list1.add(ints[i]);
            }
            lengthwaysList.add(list1);
        }
            int count = 0;
            for (List<Integer> acrossData : acrossList) {
                for (List<Integer> lengthwaysData : lengthwaysList) {
                    if(equalList(acrossData,lengthwaysData)){
                        count++;
                    }
                }
            }
            return count;
        }

    private static boolean equalList(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
