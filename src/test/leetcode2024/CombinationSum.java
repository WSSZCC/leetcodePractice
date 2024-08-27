package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSum {
    static boolean isTrue;

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        isTrue = false;
        backtrack(target,n,candidates,new ArrayList<>(),list,0);
        return list;
    }

    private static void backtrack(int target, int n, int[] candidates, ArrayList<Integer> list, List<List<Integer>> targetList, int index) {
        if(target<=0){
            if(target==0){
                targetList.add(new ArrayList<>(list));
            }
            isTrue = true;
            return;
        }
        for (int i = index; i < n; i++) {
            target -= candidates[i];
            list.add(candidates[i]);
            backtrack(target,n,candidates,list,targetList,i);
            target+=candidates[i];
            list.remove(list.size()-1);
            if(isTrue){
                isTrue = false;
                break;
            }
        }
    }
}
