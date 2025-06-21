package test.leetcode2025;

import java.util.Arrays;

/**
 * 成为 K 特殊字符串需要删除的最少字符数
 */
public class MinimumDeletions {
    public int minimumDeletions(String word, int k) {
        int[] ints = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ints[word.charAt(i)-'a']++;
        }
        Arrays.sort(ints);
        int n = 26;
        int ans = Integer.MAX_VALUE;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int flag = ints[i]+k;
            int value = pre;
            for (int j = i+1; j < n; j++) {
                if(ints[j]>flag){
                    value+=ints[j]-flag;
                }
            }
            ans = Math.min(ans,value);
            pre+=ints[i];
        }
        return ans;
    }
}
