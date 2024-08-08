package test.leetcode2024;

import java.util.Arrays;

/**
 * 找出与数组相加的整数 II
 */
public class MinimumAddedInteger {
    public static void main(String[] args) {
        minimumAddedInteger(new int[]{4,6,3,1,4,2,10,9,5},new int[]{5,10,3,2,6,1,9});
    }
    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int minValue = Integer.MAX_VALUE;
        int[] ints = new int[3];
        for (int i = 0;i<3;i++){
            ints[i] = nums2[m-1]-nums1[n-i-1];
        }
        for (int i = 0; i < ints.length; i++) {
            int count = 2-i;
            int index = 0;
            for (int j = 0; j < n-i; j++) {
                if(nums2[index]-nums1[j]!=ints[i]){
                    if(count>0){
                        count--;
                        continue;
                    }
                    ints[i] = Integer.MAX_VALUE;
                    break;
                }
                index++;
            }
            minValue = Math.min(minValue,ints[i]);
        }
        return minValue;
    }
}
