package test.leetcode2024;

import java.util.Scanner;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        productExceptSelf(new int[]{-1,1,0,-3,3});

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }
        for (int i = 0; i < left.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
