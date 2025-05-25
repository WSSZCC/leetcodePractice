package test.leetcode2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 连接两字母单词得到的最长回文串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"}));
    }
    public static int longestPalindrome(String[] words) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        int count = 0;
        for (String word : words) {
            char[] chars = word.toCharArray();
            if(chars[0]==chars[1]){
                Integer orDefault = map1.getOrDefault(word, 0);
                map1.put(word,orDefault+1);
                continue;
            }
            set.add(word);
            Integer orDefault = map.getOrDefault(word, 0);
            map.put(word,orDefault+1);
        }
        ArrayList<String> list = new ArrayList<>(set);
        for (String s : list) {
            char[] chars = s.toCharArray();
            if(map.containsKey(s)&&map.containsKey(chars[1]+""+chars[0])){
                int min = Math.min(map.get(s), map.get(chars[1] + "" + chars[0]));
                count +=min*4;
                map.remove(s);
            }
        }
        boolean flag = true;
        for (Integer value : map1.values()) {
            if(value%2==0){
                count+=value*2;
            }else {
                if(flag){
                    count+=2;
                    flag = false;
                }
                count+=(value-1)*2;
            }
        }
        return count;
    }
}
