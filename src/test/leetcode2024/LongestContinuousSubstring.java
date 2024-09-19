package test.leetcode2024;

/**
 * 最长的字母序连续子字符串的长度
 */
public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int maxLen = 1;
        int len = 1;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if(s.charAt(i)-s.charAt(i-1)==1){
                maxLen = Math.max(maxLen,len);
                len=1;
            }else {
                len++;
            }
        }
        return Math.max(maxLen,len);
    }
}
