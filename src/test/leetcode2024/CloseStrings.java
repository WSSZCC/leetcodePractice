package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 确定两个字符串是否接近
 */
public class CloseStrings {
    public static void main(String[] args) {
        closeStrings("cacbbb","abbccc");
    }

    public static  boolean closeStrings(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }
        Map<Integer, Integer> map1 = genHashMapByChars(chars1);
        Map<Integer, Integer> map2 = genHashMapByChars(chars2);
        Set<Integer> set1 = new HashSet<>(map1.keySet());
        int n = set1.size();
        set1.addAll(new HashSet<>(map2.keySet()));
        if (n != set1.size()) {
            return false;
        }
        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Integer> genHashMapByChars(char[] chars) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer count = map.getOrDefault(c - 'a', 0);
            map.put(c - 'a', count + 1);
        }
        return map;
    }

}
