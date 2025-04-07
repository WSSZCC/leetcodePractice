package test.leetcode2025;

import java.util.Arrays;

/**
 * 分割等和子集
 */
public class CanPartition {
    boolean isTrue;
    int[][] ints;
    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int num : nums) {
            sum+=num;
        }
        int target = sum/2;
        if(sum%2==1){
            return false;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n-1]>target){
            return false;
        }
        ints = new int[n + 1][target + 1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(ints[i],-1);
        }
        return dfs(nums,target,n-1);
    }

    private boolean dfs(int[] nums, int target, int index){
        if(index<0){
            return target==0;
        }
        if(ints[index][target]!=-1){
            return ints[index][target]==1;
        }
        boolean res =  target>=nums[index]&&dfs(nums,target-nums[index],index-1)||dfs(nums,target,index-1);
        ints[index][target] = res?1:0;
        return res;
    }

    private void dfs1(int[] nums, int target, int index) {
        if(target==0){
            isTrue = true;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            dfs(nums,target-nums[i],i+1);
            if(isTrue){
                break;
            }
        }
    }
}
