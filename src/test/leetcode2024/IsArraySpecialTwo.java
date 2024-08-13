package test.leetcode2024;

import java.util.*;

/**
 * 特殊数组 II
 */
public class IsArraySpecialTwo {
    public static void main(String[] args) {
        isArraySpecial(new int[]{10,4,9,5},
                new int[][]{{2,3}});
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] booleans = new boolean[m];
        Arrays.fill(booleans, true);
        if (n == 1) {
            return booleans;
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int preValue = nums[i - 1] % 2;
            int curValue = nums[i] % 2;
            if ((preValue == 0 && curValue == 0 || (preValue == 1 && curValue == 1))) {
                if (map.containsKey(i - 1)) {
                    int[] ints = map.get(i - 1);
                    map.remove(i-1);
                    map.put(i, new int[]{ints[0], i});
                } else {
                    map.put(i, new int[]{i - 1, i});
                }
            }
        }
        List<int[]> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(a -> a[0]));
        if (list.isEmpty()) {
            return booleans;
        }
        int minValue = list.get(0)[0];
        int maxValue = list.get(list.size() - 1)[1];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            if (right <= minValue || left >= maxValue || left == right) {
                continue;
            }
            int index = 0;
            int maxIndex = list.size()-1;
            while (index<=maxIndex){
                int midIndex = index+(maxIndex-index)/2;
                int[] ints = list.get(midIndex);
                if ((left <= ints[0] && right > ints[0]) || (left < ints[1] && right >= ints[1])||(left>=ints[0]&&right<=ints[1])) {
                    booleans[i] = false;
                    break;
                }
                if(right<=ints[0]){
                    maxIndex = midIndex-1;
                }else {
                    index = midIndex+1;
                }
            }
        }
        return booleans;
    }
}
