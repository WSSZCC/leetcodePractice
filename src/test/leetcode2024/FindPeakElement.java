package test.leetcode2024;

import java.util.Arrays;

/**
 * 寻找峰值
 */
public class FindPeakElement {
    public static void main(String[] args) {
        findPeakElement(new int[]{3,4,3,2,1});
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        if(n==1||nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-2]<nums[n-1]){
            return n-1;
        }
        while(left<right){
            int index = left + (right-left)/2;
            if(nums[index-1]>nums[index]){
                right = index;
            }else {
                if(nums[index]>nums[index+1]){
                    return index;
                }
                left = index;
            }
        }
        return -1;
    }

    public static int findPeakElement1(int[] nums) {
        int n = nums.length;
        int[] temps = new int[n];
        for (int i = 0; i < nums.length; i++) {
            temps[i] = nums[i];
        }
        Arrays.sort(temps);
        int maxValue = temps[n-1];
        for (int i = 0; i < n; i++) {
            if(maxValue == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
