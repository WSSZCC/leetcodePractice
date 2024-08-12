package test.leetcode2024;

import java.util.*;

/**
 * 实现一个魔法字典
 */
public class MagicDictionary {
    private final Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int n = s.length();
            List<String> list = map.getOrDefault(n, new ArrayList<>());
            list.add(s);
            map.put(n, list);
        }
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        List<String> list = Optional.ofNullable(map.get(n)).orElse(new ArrayList<>());
        if(!list.isEmpty()){
            for (String value : list) {
                if (value.length() == n) {
                    int changeCount = 1;
                    for (int j = 0; j < n; j++) {
                        if (value.charAt(j) != searchWord.charAt(j)) {
                            changeCount--;
                        }
                        if (changeCount < 0) {
                            break;
                        }
                    }
                    if (changeCount == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
