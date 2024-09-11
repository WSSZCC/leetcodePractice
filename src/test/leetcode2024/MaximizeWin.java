package test.leetcode2024;

import java.util.*;

/**
 * 两个线段获得的最多奖品
 */
public class MaximizeWin {

    public int maximizeWin(int[] prizePositions, int k) {
        List<int[]> list = new ArrayList<>();
        for (int prizePosition : prizePositions) {
            if (list.isEmpty()) {
                list.add(new int[]{prizePosition, 1});
            } else {
                int m = list.size();
                if (list.get(m - 1)[0] < prizePosition) {
                    list.add(new int[]{prizePosition, 1});
                }
                for (int i = m - 1; i >= 0; i--) {
                    int[] ints = list.get(i);
                    if (ints[0] + k < prizePosition) {
                        break;
                    }
                    ints[1] += 1;
                    list.set(i, ints);
                }
            }
        }
        int maxValue = 0;
        int m = list.size();
        for (int[] ints : list) {
            int sum = 0;
            for (int j = m - 1; j >= 0; j--) {
                int[] ints1 = list.get(j);
                if (ints[0] + k >= ints1[0]) {
                    break;
                }
                sum = Math.max(sum, ints1[1]);
            }
            maxValue = Math.max(sum + ints[1], maxValue);
        }
        return maxValue;
    }

    public int maximizeWin1(int[] prizePositions, int k) {
        List<int[]> list = new ArrayList<>();
        genList(prizePositions, k, list);
        int m = list.size();
        return getMaxValue(k, list, m);
    }

    private int getMaxValue(int k, List<int[]> list, int m) {
        int maxValue = 0;
        for (int[] ints : list) {
            int sum = 0;
            for (int j = m - 1; j >= 0; j--) {
                int[] ints1 = list.get(j);
                if (ints[0] + k >= ints1[0]) {
                    break;
                }
                sum = Math.max(sum, ints1[1]);
            }
            maxValue = Math.max(sum + ints[1], maxValue);
        }
        return maxValue;
    }

    private void genList(int[] prizePositions, int k, List<int[]> list) {
        for (int prizePosition : prizePositions) {
            if (list.isEmpty()) {
                list.add(new int[]{prizePosition, 1});
            } else {
                int m = list.size();
                if (list.get(m - 1)[0] < prizePosition) {
                    list.add(new int[]{prizePosition, 1});
                }
                for (int i = m - 1; i >= 0; i--) {
                    int[] ints = list.get(i);
                    if (ints[0] + k < prizePosition) {
                        break;
                    }
                    ints[1] += 1;
                    list.set(i, ints);
                }
            }
        }
    }
}
