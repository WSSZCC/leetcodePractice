package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 整数转罗马数字
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = genComparisonMap();
        List<Integer> keyList = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuilder sb = new StringBuilder();
        for (Integer key : keyList) {
            while (num >= key) {
                if (num - key >= 0) {
                    num = num - key;
                    sb.append(map.get(key));
                }
            }
        }
        return sb.toString();
    }

    private static LinkedHashMap<Integer, String> genComparisonMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }
}
