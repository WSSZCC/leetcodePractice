package test.leetcode2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长特殊序列 II
 */
public class FindLUSlength {
    public static void main(String[] args) {
        String s ="aaa";
        System.out.println(s.substring(0,3));
        findLUSlength(new String[]{"aabbcc", "aabbcc","c","e","aabbcd"});
    }

    public static int findLUSlength(String[] strs) {
        int n = strs.length;
//        Arrays.sort(strs, Comparator.comparingInt(a->-a.length()));
//        if(strs[0].length()>strs[1].length()){
//            return strs[0].length();
//        }
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(!set.isEmpty()&&set.contains(i)){
                continue;
            }
            int len = strs[i].length();
            for (int j = 0; j < n; j++) {
                if(!set.isEmpty()&&set.contains(j)){
                    continue;
                }
                if(i!=j){
                    int length = strs[j].length();
                    if(len>length){
                        int k=0;
                        int m =0;
                        while (k<len&&m<length){
                            int index = strs[i].substring(k,len).indexOf(strs[j].charAt(m));
                            if(index==-1){
                                break;
                            }
                            k = k+index+1;
                            m++;
                        }
                        if(m==length){
                            set.add(j);
                        }
                    }else if(len==length) {
                        if(strs[i].equals(strs[j])){
                            set.add(i);
                            set.add(j);
                        }
                    }
                }
            }

        }
        if(set.size()==n){
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if(!set.isEmpty()&&!set.contains(i)){
                continue;
            }
            maxLen = Math.max(strs[i].length(),maxLen);
        }
        return maxLen;
    }
}
