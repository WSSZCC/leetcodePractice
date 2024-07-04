package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大连续1的个数 III
 */
public class LongestOnes {
    public static void main(String[] args) {
        longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    private static int longestOnes(int[] nums, int k) {
        int maxValue = 0;
        int n = nums.length;
        int firstIndex = 0;
        int lastIndex = -1;
        int firstZeroIndex = 0;
        while (lastIndex < n - 1) {
            int count = 1;
            int flag = k;
            for (int i = firstIndex; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (count == 1) {
                        firstZeroIndex = i;
                        count--;
                    }
                    flag--;
                }
                if (flag < 0) {
                    break;
                }
                lastIndex = i;
            }
            maxValue = Math.max(maxValue, lastIndex - firstIndex + 1);
            firstIndex = firstZeroIndex + 1;
            // k==0 时处理
            if (firstIndex == n) {
                lastIndex = firstIndex;
            }
        }

        return maxValue;
    }
}
