package test.leetcode2025;

/**
 * 小于等于 K 的最长二进制子序列
 */
public class LongestSubsequence {
    public int longestSubsequence(String s, int k) {
        String k1 = Integer.toBinaryString(k);
        int m = k1.length();
        int n = s.length();
        if (n < m) {
            return n;
        }
        int bigInteger = Integer.parseInt(s.substring(n-m, n), 2);
        if (bigInteger>k) {
            m--;
        }
        for (int i =n-m-1; i >=0; i--) {
            if(s.charAt(i)=='0'){
                m++;
            }
        }
        return m;
    }
}
