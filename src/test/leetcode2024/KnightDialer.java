package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 骑士拨号器
 */
public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(2));
    }
    public static int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        HashMap<Character, char[]> baseMap = genBaseMap();
        char[] chars = {'0', '1', '2', '3', '4', '6', '7', '8', '9'};
        Map<Character, Long> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar,1L);
        }
        for (int i = 1; i < n-1; i++) {
            Map<Character, Long> map1 = new HashMap<>();
            for (char aChar : chars) {
                char[] chars1 = baseMap.get(aChar);
                Long times = map.get(aChar);
                for (char c : chars1) {
                    Long orDefault = map1.getOrDefault(c, 0L);
                    map1.put(c,(orDefault+times)%1000000007);
                }
            }
            map = map1;
        }
        long count = 0L;
        for (char aChar : chars) {
            count = (count+map.get(aChar)*baseMap.get(aChar).length)%1000000007;
        }
        return (int) count;
    }

    private static HashMap<Character, char[]> genBaseMap() {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('1', new char[]{'6', '8'});
        map.put('2', new char[]{'7', '9'});
        map.put('3', new char[]{'4', '8'});
        map.put('4', new char[]{'0', '3', '9'});
        map.put('6', new char[]{'0', '1', '7'});
        map.put('7', new char[]{'2', '6'});
        map.put('8', new char[]{'1', '3'});
        map.put('9', new char[]{'2', '4'});
        map.put('0',new char[]{'4','6'});
        return map;
    }
}
