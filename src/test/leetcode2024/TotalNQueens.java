package test.leetcode2024;

import java.util.*;

/**
 * N 皇后 II
 */
public class TotalNQueens {

    static boolean[][] booleans;
    static Set<Integer> set;
    static int total;

    public static void main(String[] args) {
        System.out.println(totalNQueens(2));
    }

    public static int totalNQueens(int n) {
        total = 0;
        booleans = new boolean[n][n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i], false);
        }
        backtrack(0, n);
        return total;
    }

    private static void backtrack(int row, int n) {
        if (set.size() == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i) || booleans[row][i]) {
                continue;
            }
            set.add(i);
            Set<String> tempSet = new HashSet<>();
            for (int j = row + 1; j < n; j++) {
                if (booleans[j][i]) {
                    tempSet.add(j + "" + i);
                    continue;
                }
                booleans[j][i] = true;
            }
            for (int j = 0; j < i; j++) {
                if (i - j + row >= n) {
                    continue;
                }
                if (booleans[i - j + row][j]) {
                    tempSet.add((i - j + row) + "" + j);
                    continue;
                }
                booleans[i - j + row][j] = true;
            }
            int x = row;
            for (int j = i + 1; j < n; j++) {
                x++;
                if (x >= n) {
                    break;
                }
                if (booleans[x][j]) {
                    tempSet.add(x + "" + j);
                    continue;
                }
                booleans[x][j] = true;
            }
            backtrack(row + 1, n);
            for (int j = row + 1; j < n; j++) {
                if (tempSet.contains(j + "" + i)) {
                    continue;
                }
                booleans[j][i] = false;
            }
            for (int j = 0; j < i; j++) {
                if (i - j + row >= n || tempSet.contains((i - j + row) + "" + j)) {
                    continue;
                }
                booleans[i - j + row][j] = false;
            }
            int x1 = row;
            for (int j = i + 1; j < n; j++) {
                x1++;
                if (x1 >= n) {
                    break;
                }
                if (tempSet.contains(x1 + "" + j)) {
                    continue;
                }
                booleans[x1][j] = false;
            }
            set.remove(i);
        }
    }
}
