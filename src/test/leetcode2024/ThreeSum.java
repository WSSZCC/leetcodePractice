package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        threeSum(new int[]{3,0,3,2,-4,0,-3,2,2,0,-1,-5});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        Map<String, List<Integer>> threeMap = new HashMap<>();
        for (int i = 1; i < n - 1; i++) {
            if (!map.containsKey(nums[0] + nums[i])) {
                map.put(nums[0] + nums[i], new int[]{0, i});
            }
        }
        for (int i = 1; i < n - 2; i++) {
            Map<Integer, int[]> map1 = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(-nums[j])) {
                    int[] ints = map.get(-nums[j]);
                    if (ints[1] < j) {
                        List<Integer> list = Arrays.asList(nums[ints[0]], nums[ints[1]], nums[j]);
                        String s = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
                        threeMap.put(s, list);
                        map.remove(-nums[j]);
                    }
                }
                if (j < n - 1 && !map1.containsKey(nums[i] + nums[j])) {
                    map1.put(nums[i] + nums[j], new int[]{i, j});
                }
            }
            map = map1;
        }
        if (!map.isEmpty() && map.containsKey(-nums[n - 1])) {
            int[] ints = map.get(-nums[n - 1]);
            List<Integer> list = Arrays.asList(nums[ints[0]], nums[ints[1]], nums[n - 1]);
            String s = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
            threeMap.put(s, list);
            map.remove(-nums[n - 1]);
        }
        return new ArrayList<>(threeMap.values());

    }

    /**
     * @param nums
     * @return 暴力法
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        String s = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
                        map.put(s, list);
                    }
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
