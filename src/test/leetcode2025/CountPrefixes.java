package test.leetcode2025;

/**
 * 统计是给定字符串前缀的字符串数目
 */
public class CountPrefixes {
    public int countPrefixes(String[] words, String s) {
        int count =0;
        for (String word : words) {
            int n = word.length();
            if(n<=s.length()&&s.substring(0,n).equals(word)){
               count++;
            }
        }
        return count;
    }
}
