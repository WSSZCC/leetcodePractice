package test.leetcode2025;

/**
 * 3110. 字符串的分数
 */
public class ScoreOfString {
    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans+=Math.abs(s.charAt(i-1)-s.charAt(i));
        }
        return ans;
    }
}
