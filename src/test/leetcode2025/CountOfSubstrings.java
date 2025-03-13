package test.leetcode2025;

import java.util.HashMap;

/**
 * 元音辅音字符串计数 I
 */
public class CountOfSubstrings {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        HashMap<Character, Integer> map = buildMap();
        int count = 0;
        int flag = k;
        for (int i = 0; i < 5 + k; i++) {
            char c = word.charAt(i);
            if(!map.containsKey(c)){
                flag--;
            }
            map.computeIfPresent(c, (key, v) -> v + 1);
        }
        if(flag==0&&check(map)){
            count++;
        }
        for (int i = 5+k; i < n; i++) {
            if(flag>=0){
                HashMap<Character, Integer> map1 = new HashMap<>(map);
                int flag1= flag;
                for (int j = i; j < n; j++) {
                    char c1 = word.charAt(j);
                    if(!map1.containsKey(c1)){
                        flag1--;
                    }
                    if(flag1<0){
                        break;
                    }
                    map1.computeIfPresent(c1, (key, v) -> v+1);
                    if(flag1==0&&check(map1)) {
                        count++;
                    }
                }
            }
            char c = word.charAt(i-5-k);
            if(!map.containsKey(c)){
                flag++;
            }
            map.computeIfPresent(c, (key, v) -> v-1);
            char c1 = word.charAt(i);
            if(!map.containsKey(c1)){
                flag--;
            }
            map.computeIfPresent(c1, (key, v) -> v+1);
            if(flag==0&&check(map)){
                count++;
            }
        }
        return count;
    }

    private HashMap<Character, Integer> buildMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('u',0);
        map.put('o',0);
        return map;
    }

    private boolean check(HashMap<Character, Integer> map) {
        return map.get('a')>=1&&map.get('e')>=1&&map.get('i')>=1&&map.get('u')>=1&&map.get('o')>=1;
    }
}
