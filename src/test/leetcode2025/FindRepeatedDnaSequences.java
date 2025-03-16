package test.leetcode2025;

import java.util.*;

/**
 * 重复的DNA序列
 */
public class FindRepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> set1 = new HashSet<>();
        StringBuilder sb = new StringBuilder();
       int flag = 10;
        for (int i = 0; i < n; i++) {
            if(flag>0){
                sb.append(s.charAt(i));
                flag--;
                continue;
            }
            set.add(sb.toString());
            sb.delete(0,1);
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())){
                set1.add(sb.toString());
            }
            set.add(sb.toString());
        }
        return new ArrayList<>(set1);
    }
}
