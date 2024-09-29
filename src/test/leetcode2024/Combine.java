package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n,k,1,new ArrayList<>(),list);
        return list;
    }

    private void backtrack(int n, int k, int index, List<Integer> currentList, List<List<Integer>> targetList) {
        if(0==k){
            targetList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < n-k+1; i++) {
            currentList.add(i);
            k--;
            backtrack(n,k,i+1,currentList,targetList);
            k++;
            currentList.remove(currentList.size()-1);
        }

    }
}
