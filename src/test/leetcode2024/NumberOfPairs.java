package test.leetcode2024;

import java.util.Arrays;

/**
 * 优质数对的总数 I
 */
public class NumberOfPairs {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < m; i++) {
            nums2[i]*=k;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        for (int i = n-1; i >=0; i--) {
            int flag = 0;
            for (int value : nums2) {
                if (value > nums1[i]) {
                    break;
                }
                flag++;
                if (nums1[i] % value == 0) {
                    count++;
                }
            }
            if(flag==0){
                break;
            }
        }
        return count;
    }
}
