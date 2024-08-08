package test.leetcode2024;

/**
 * 找出与数组相加的整数 I
 */
public class AddedInteger {
    public int addedInteger(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 1; i < n; i++) {
            nums1[i] = Math.min(nums1[i-1],nums1[i]);
            nums2[i] = Math.min(nums2[i-1],nums2[i]);
        }
        return nums1[n-1]-nums2[n-1];
    }
}
