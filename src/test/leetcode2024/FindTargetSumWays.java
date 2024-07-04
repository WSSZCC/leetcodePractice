package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标和
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1},3);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        calTargetSum(nums, n, target, 0, 1, list);
        int targetSum = 0;
        for (Integer integer : list) {
            targetSum += integer;
        }
        return targetSum;
    }

    private static void calTargetSum(int[] nums, int totalLen, int target, int current, int index, List<Integer> list) {
        if (index == totalLen) {
            list.add(target == current+nums[index-1] ? 1 : 0);
            list.add(target == current-nums[index-1] ? 1 : 0);
            return;
        }
        int num = nums[index - 1];
        calTargetSum(nums,totalLen,target,current+num,index+1,list);
        calTargetSum(nums,totalLen,target,current-num,index+1,list);
    }
}
