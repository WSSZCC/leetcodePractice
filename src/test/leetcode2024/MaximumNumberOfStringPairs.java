package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大字符串配对数目
 */
public class MaximumNumberOfStringPairs {
    public static void main(String[] args) {

    }

    public int maximumNumberOfStringPairs1(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String word : words) {
            String s = String.format("%s%s", word.charAt(1), word.charAt(0));
            Integer orDefault = map.getOrDefault(s, 0);
            if(orDefault==1){
                map.remove(s);
                count++;
            }else {
                map.put(word,orDefault+1);
            }
        }
        return count;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char a = word.charAt(0);
            char b = word.charAt(1);
            for (int j = i+1; j < n; j++) {
                String word1 = words[j];
                char a1 = word1.charAt(0);
                char b1 = word1.charAt(1);
                if(a==b1&&b==a1){
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
}
