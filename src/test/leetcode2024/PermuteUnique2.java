package test.leetcode2024;

import java.util.*;

/**
 * 全排列 II
 */
public class PermuteUnique2 {
    Set<String> set;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        set = new HashSet<>();
        List<List<Integer>> targetList = new ArrayList<>();
        dfs(n,nums,new HashSet<>(),new ArrayList<>(),targetList);
        return targetList;
    }

    private void dfs(int n, int[] nums, Set<Integer> set1,List<Integer> list, List<List<Integer>> targetList) {
        if(set1.size()==n){
            if(!set.contains(list.toString())){
                set.add(list.toString());
                targetList.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(set1.contains(i)){
                continue;
            }
            set1.add(i);
            list.add(nums[i]);
            dfs(n,nums,set1,list,targetList);
            list.remove(list.size()-1);
            set1.remove(i);
        }

    }
}
