package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Subsets {
    List<List<Integer>> ansList;

    public List<List<Integer>> subsets(int[] nums){
        int n = nums.length;
        ansList = new ArrayList<>();
        backtrack(n,0,nums,new ArrayList<>());
        return ansList;
    }

    private void backtrack(int n,int index,int[] nums, List<Integer> list) {
        ansList.add(new ArrayList<>(list));
        for (int i = index; i < n; i++) {
            list.add(nums[i]);
            backtrack(n,i+1,nums,list);
            list.remove(list.size()-1);
        }
    }

}
