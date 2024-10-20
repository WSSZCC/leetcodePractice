package test.leetcode2024;

import java.util.Arrays;

/**
 * 好数对的数目
 */
public class NumIdenticalPairs {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{2,1,3,2}));
    }
    public static int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int value = nums[0];
        int flag = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i]==value){
               count+=flag;
               flag++;
            }else {
                flag=1;
                value = nums[i];
            }
        }
        return count;
    }
}
