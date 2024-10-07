package test.leetcode2024;

import java.util.*;

/**
 * 四数之和
 */
public class FourSum {
    private int[] ints;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        ints = nums;
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n,0,3,0,target, new ArrayList<>(),list);
        return list;
    }

    private void backtrack(int n, int index,int maxLen, long sum,int target, List<Integer> currentList, List<List<Integer>> targetList) {
        if(maxLen==0){
            for (int i = index; i < n; i++) {
                long value = sum + ints[i];
                if(value >=target){
                    if(value ==target){
                        targetList.add(Arrays.asList(ints[currentList.get(0)],ints[currentList.get(1)],ints[currentList.get(2)],ints[i]));
                    }
                    break;
                }
            }
            return;
        }
        for (int i = index; i < n; i++) {
            if(i>index&&ints[i]==ints[i-1]){
                continue;
            }
            maxLen--;
            currentList.add(i);
            sum+=ints[i];
            backtrack(n,i+1,maxLen,sum,target,currentList,targetList);
            currentList.remove(currentList.size()-1);
            sum-=ints[i];
        }
    }
}
