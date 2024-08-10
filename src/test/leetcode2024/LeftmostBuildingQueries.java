package test.leetcode2024;

import java.util.*;

/**
 * 找到 Alice 和 Bob 可以相遇的建筑
 */
public class LeftmostBuildingQueries {
    public static void main(String[] args) {
        leftmostBuildingQueries(new int[]{6,4,8,5,2,7}, new int[][]{{0,1},{0,3},{2,4},{3,4},{2,2}});
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        int m = heights.length;
        int[] ints = new int[n];
        int[][] ints1 = new int[m][2];
        for (int i = 0; i < m; i++) {
            ints1[i] = new int[]{heights[i], i};
        }
        Arrays.sort(ints1, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints1.length; i++) {
            map.put(ints1[i][0], i);
        }
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int left = Math.min(query[0], query[1]);
            int right = Math.max(query[0], query[1]);
            if (left == right) {
                ints[i] = left;
            } else {
                int value = -1;
                int leftValue = heights[left];
                int rightValue = heights[right];
                if (leftValue < rightValue) {
                    value = right;
                } else {
                    Integer index = map.get(leftValue);
                    for (int j = index+1; j < m; j++) {
                        int[] ints2 = ints1[j];
                        if(ints2[1]>right){
                            if(value==-1) {
                                value = ints2[1];
                            }else{
                                value = Math.min(value,ints2[1]);
                            }
                        }
                    }
                }
                ints[i] = value;
            }
        }
        return ints;
    }

}
