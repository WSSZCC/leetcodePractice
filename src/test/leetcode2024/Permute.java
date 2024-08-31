package test.leetcode2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        dfs(n,new HashSet<>(),new ArrayList<>(),list,nums);
        return list;
    }

    private void dfs(int n, Set<Integer> set, List<Integer> list, List<List<Integer>> targetList, int[] nums) {
        if(set.size()==n){
            targetList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            list.add(nums[i]);
            dfs(n,set,list,targetList,nums);
            set.remove(i);
            list.remove(list.size()-1);
        }
    }
}
