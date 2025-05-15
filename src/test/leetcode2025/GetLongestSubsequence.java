package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长相邻不相等子序列 I
 */
public class GetLongestSubsequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < n; i++) {
            if(groups[i]!=groups[i-1]){
                list.add(words[i]);
            }
        }
        return list;
    }
}
