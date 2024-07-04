package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计出现过一次的公共字符串
 */
public class CountWords {
    public static void main(String[] args) {
        countWords(new String[]{},new String[]{});
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words2) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count - 1);
        }
        for (String s : words1) {
            Integer count = map.getOrDefault(s, 0);
            if(count>=-1) {
                map.put(s, count + 1);
            }
        }
        return (int) map.values().stream().filter(data -> data == 0).count();
    }
}
