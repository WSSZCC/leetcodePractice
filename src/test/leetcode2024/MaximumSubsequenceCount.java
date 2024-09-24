package test.leetcode2024;

/**
 * 字符串中最多数目的子序列
 */
public class MaximumSubsequenceCount {
    public static void main(String[] args) {
        maximumSubsequenceCount("aca","aa");
    }
    public static long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        long count1 = 0;
        long count2 = 0;
        int len1 = 1;
        int len2 = 0;
        char p1 = pattern.charAt(0);
        char p2 = pattern.charAt(1);
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if(c == p1){
                len1++;
                len2++;
            }
            if(c== p2){
                count1+=len1;
                count2+=len2;
            }
        }
        if(p1 != p2) {
            count2 += len2;
        }else {
            count1-=len1;
        }
        return Math.max(count1,count2);
    }
}
