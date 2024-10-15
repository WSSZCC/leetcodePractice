package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 */
public class SubsetsWithDup {
    private List<List<Integer>> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        list = new ArrayList<>();
        backtrack(0, n, nums, new ArrayList<>());
        return list;
    }

    private void backtrack(int index, int n, int[] nums, List<Integer> currentList) {
        list.add(new ArrayList<>(currentList));
        for (int i = index; i < n; i++) {
            if(index<i&&nums[i]==nums[i-1]){
                continue;
            }
            currentList.add(nums[i]);
            backtrack(i+1,n,nums,currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
