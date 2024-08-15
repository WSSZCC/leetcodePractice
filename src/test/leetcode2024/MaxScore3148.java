package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 矩阵中的最大得分
 */
public class MaxScore3148 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,4,2,5,10);
        List<Integer> list1 = Arrays.asList(6,7,2,3,10);
        List<Integer> list2 = Arrays.asList(1,3,4,10,7);
        List<Integer> list3 = Arrays.asList(2,6,7,3,4);
        List<Integer> list4 = Arrays.asList(8, 3, 8, 3, 1);
        maxScore(Arrays.asList(list,list1,list2,list3,list4));
    }

    public static int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int ans = Integer.MIN_VALUE;
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            List<Integer> list = grid.get(i);
            for (int j = 0; j < m; j++) {
                ints[i][j] = list.get(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = ints[i][j];
                if(i>0) {
                    ans = Math.max(ans, value - ints[i - 1][j]);
                    ints[i][j] = Math.min(ints[i][j],ints[i-1][j]);
                }
                if(j>0) {
                    ans = Math.max(ans, value - ints[i][j-1]);
                    ints[i][j] = Math.min(ints[i][j],ints[i][j-1]);
                }
            }
        }
        return ans;
    }


    /**
     * @param grid
     * @return
     * 暴力法
     */
    public static int maxScore1(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = grid.get(i);
            for (int j = 0; j < m; j++) {
                Integer value = list.get(j);
                for (int k = j + 1; k < list.size(); k++) {
                    int targetValue = list.get(k) - value;
                    if (ints[i][k] == Integer.MIN_VALUE || ints[i][j] == Integer.MIN_VALUE) {
                        ints[i][k] = targetValue;
                    } else {
                        ints[i][k] = Math.max(Math.max(targetValue,targetValue+ints[i][j]),ints[i][k]);
                    }
                }
                for (int k = i+1; k < n; k++) {
                    int targetValue = grid.get(k).get(j) - value;
                    if (ints[k][j] == Integer.MIN_VALUE || ints[i][j] == Integer.MIN_VALUE) {
                        ints[k][j] = targetValue;
                    } else {
                        ints[k][j] = Math.max(Math.max(targetValue,targetValue+ints[i][j]),ints[k][j]);
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ints[i][j],ans);
            }
        }
        return ans;
    }
}
