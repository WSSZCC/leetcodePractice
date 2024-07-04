package test.leetcode2024;

/**
 * 判断子序列
 */
public class IsSubsequence {
    public static void main(String[] args) {
        isSubsequence("axs","assscs");
    }

    public static boolean isSubsequence(String s, String k) {
        int n = s.length();
        int m = k.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == k.charAt(j)) {
                i++;
            }
            j++;
        }
        return n == i;
    }
}
