package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class Partition {
    List<List<String>> list;


    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        backtrack(s,s.length(),0,new ArrayList<>());
        return list;
    }

    private void backtrack(String s, int n, int index, List<String> targetList) {
        if(index==n){
            list.add(new ArrayList<>(targetList));
            return;
        }
        int len = 1;
        while (len<=n-index){
            String s1 = s.substring(index, index + len);
            if(!s1.equals(new StringBuilder(s1).reverse().toString())){
                len++;
                continue;
            }
            targetList.add(s1);
            backtrack(s,n,index+len,targetList);
            len++;
            targetList.remove(targetList.size()-1);
        }
    }
}
