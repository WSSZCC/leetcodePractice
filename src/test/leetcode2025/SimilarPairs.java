package test.leetcode2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 统计相似字符串对的数目
 */
public class SimilarPairs {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2};
        int[] ints1 = new int[]{1,2};
        HashSet<Character> set = new HashSet<>();
        set.add('c');
        set.add('a');
        set.add('b');
        System.out.println(Arrays.toString(set.toArray()));
    }
    public int similarPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            HashSet<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            String s = Arrays.toString(set.toArray());
            Integer orDefault = map.getOrDefault(s, 0);
            map.put(s,orDefault+1);
        }
        Integer[] array = map.values().toArray(new Integer[0]);
        int ans = 0;
        for (Integer integer : array) {
            if(integer>1){
                int flag = integer-1;
                while (flag>0){
                    ans+=flag;
                    flag--;
                }
            }
        }
        return  ans;
    }
}
