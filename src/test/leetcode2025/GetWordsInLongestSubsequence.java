package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长相邻不相等子序列 II
 */
public class GetWordsInLongestSubsequence {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] ints = new int[n];
        int[] ints1 = new int[n];
        int flag = n-1;
        for (int i = n-1;i>=0;i--){
            for (int j = i+1; j < n; j++) {
                if(ints[i]<ints[j]&&groups[i]!=groups[j]&&isTrue(words[i],words[j])){
                    ints[i] = ints[j];
                    ints1[i] = j;
                }
            }
            ints[i]++;
            if(ints[i]>ints[flag]){
                flag = i;
            }
        }
        int index = flag;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < ints[flag]; i++) {
            list.add(words[index]);
            index = ints1[index];
        }
        return list;
    }

    private boolean isTrue(String word, String word1) {
        if(word.length()!=word1.length()){
            return false;
        }
        boolean isTrue = false;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)!=word1.charAt(i)){
                if(isTrue){
                    return false;
                }
                isTrue = true;
            }
        }
        return isTrue;
    }
}
