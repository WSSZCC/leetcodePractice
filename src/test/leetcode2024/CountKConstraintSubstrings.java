package test.leetcode2024;

/**
 * 统计满足 K 约束的子字符串数量 I
 */
public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int total = 0;
        int[] ints = new int[2];
        for (int i = 0; i < n; i++) {
            ints[s.charAt(i)-'0']++;
        }
        return 0;
    }
}
