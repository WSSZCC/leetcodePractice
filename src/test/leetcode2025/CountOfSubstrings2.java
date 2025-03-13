package test.leetcode2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 元音辅音字符串计数 II
 */
public class CountOfSubstrings2 {
    Set<Character> set;
    public long countOfSubstrings(String word, int k) {
        set = buildSet();
        return count(k,word)-count(k+1,word);
    }

    private long count(int k, String word) {
        int n = word.length();
        long ans = 0;
        int flag = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (j<n&&(flag<k||map.size()<5)){
                char c = word.charAt(j);
                if(set.contains(c)){
                    Integer orDefault = map.getOrDefault(c, 0);
                    map.put(c,orDefault+1);
                }else {
                    flag++;
                }
                j++;
            }
            if(flag>=k&&map.size()==5){
                ans+=(n-j+1);
            }
            if(set.contains(word.charAt(i))){
                map.computeIfPresent(word.charAt(i),(key,value)->value-1);
                if(map.get(word.charAt(i))==0){
                    map.remove(word.charAt(i));
                }
            }else {
                flag--;
            }
        }
        return ans;
    }

    private Set<Character> buildSet() {
        return new HashSet<>(Arrays.asList('a','e','i','u','o'));
    }
}
