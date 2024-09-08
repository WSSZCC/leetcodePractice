package test.leetcode2024;

import test.practice.ResourceLoader;

/**
 * 有序数组的平方
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ints = new int[n];
        int left = 0;
        int right = n-1;
        int index = right;
        while (left<=right){
            int num = nums[left]*nums[left];
            int num1 = nums[right]*nums[right];
            if(num>num1){
                left++;
            }else {
                right--;
            }
            ints[index] = Math.max(num,num1);
            index--;
        }
        return ints;
    }
}
