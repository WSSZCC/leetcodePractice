package test.leetcode2024;

import java.util.*;

/**
 * 赎金信
 */
public class CanConstruct {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        if(n>m){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c,count+1);
        }

        for (char c : ransomNote.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            if(count==0){
                return false;
            }
            map.put(c,count-1);
        }
        return true;
    }
}
