package test.leetcode2024;

import java.util.*;

/**
 * 引爆最多的炸弹
 */
public class MaximumDetonation {
    public static void main(String[] args) {
        maximumDetonation(new int[][]{{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}});
    }

    public static int maximumDetonation(int[][] bombs) {
        int ans = 0;
        int size = bombs.length;
        for (int i = 0; i < size; i++) {
            List<int[]> list = new ArrayList<>();
            list.add(bombs[i]);
            Set set = new HashSet();
            set.add(i);
            for (int j = 0; j < list.size(); j++) {
                int[] bomb = list.get(j);
                int x = bomb[0];
                int y = bomb[1];
                int len = bomb[2];
                for (int k = 0; k < size; k++) {
                    if (set.contains(k)) {
                        continue;
                    } else {
                        long x1 = Math.abs(x - bombs[k][0]);
                        long y1 = Math.abs(y - bombs[k][1]);
                        if (x1 * x1 + y1 * y1 <= (long) (len) * (len)) {
                            list.add(bombs[k]);
                            set.add(k);
                        }
                    }
                }
            }
            ans = Math.max(ans, list.size());
        }
        return ans;
    }
}
