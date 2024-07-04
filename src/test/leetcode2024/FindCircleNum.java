package test.leetcode2024;

import java.awt.font.NumericShaper;
import java.util.HashSet;
import java.util.Set;

/**
 * 省份数量
 */
public class FindCircleNum {
    static int[] num;

    public static void main(String[] args) {
        findCircleNum(new int[][]{
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}});
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = num[i] == 0 ? i + 1 : num[i];
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (num[j] == 0) {
                        num[j] = num[i];
                    } else {
                        int value = num[i];
                        for (int k = 0; k < num.length; k++) {
                            if(num[k]==value){
                                num[k] = num[j];
                            }
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        return set.size();
    }
}
