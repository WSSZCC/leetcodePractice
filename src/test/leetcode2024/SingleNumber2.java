package test.leetcode2024;

import java.util.Arrays;

/**
 * 只出现一次的数字 II
 */
public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println();
    }
    public  int singleNumber(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        Arrays.sort(nums);
        int index = 0;

        while (index<n-1){
            int value = nums[index]^nums[index+1];
            if(value!=0){
                return nums[index];
            }
            index+=3;
        }
        return nums[n-1];
    }
}
