package test.leetcode2024;

import java.util.Arrays;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        longestCommonSubsequence1("hofubmnylkra", "pqhgxgdofcvmr");
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] ints = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints[i],0);
        }
        for (int i = 0; i < n; i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < m; j++) {
                if(c==text2.charAt(j)){
                    ints[i+1][j+1]=ints[i][j]+1;
                }else {
                    ints[i+1][j+1] = Math.max(ints[i][j+1],ints[i+1][j]);
                }
            }
        }
        return ints[n][m];
    }
    public static int longestCommonSubsequence1(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        if (n == 1 && m == 1) {
            return text1.equals(text2) ? 1 : 0;
        }
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    ints[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ints[0][j] = Math.max(ints[0][j-1], ints[0][j]);
                ints[i][j] = Math.max(ints[i - 1][j], Math.max(ints[i][j] + ints[i - 1][j - 1], ints[i][j - 1]));
            }
            ints[i][0] = Math.max(ints[i - 1][0], ints[i][0]);
        }
        return ints[n - 1][m - 1];
    }
}
