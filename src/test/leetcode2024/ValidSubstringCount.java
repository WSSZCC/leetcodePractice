package test.leetcode2024;

import java.util.Arrays;

/**
 * 统计重新排列后包含另一个字符串的子字符串数目 I
 */
public class ValidSubstringCount {
    public static long validSubstringCount(String word1, String word2) {
        int n = word2.length();
        int m = word1.length();
        if (n > m) {
            return 0;
        }
        long ans = 0;
        int count = 0;
        int[] ints = new int[26];
        int[] ints1 = new int[26];
        for (int i = 0; i < n; i++) {
            ints[word2.charAt(i) - 'a']++;
        }
        int flag = 0;
        for (int i = 0; i < m; i++) {
            ints1[word1.charAt(i) - 'a']++;
            if(i<n-1){
                continue;
            }
            if (intsEquals(ints, ints1)) {
                count++;
               while (true){
                   ints1[word1.charAt(flag) - 'a']--;
                   flag++;
                   if (!intsEquals(ints, ints1)) {
                       break;
                   }
                   count++;
               }
            }
            ans+=count;
        }
        return ans;
    }

    public static boolean intsEquals(int[] ints1, int[] ints2) {
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] == 0) {
                continue;
            }
            if (ints1[i] > ints2[i]) {
                return false;
            }
        }
        return true;
    }
}
