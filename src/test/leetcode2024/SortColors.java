package test.leetcode2024;

/**
 * 颜色分类
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            int redCount = 0;
            int whiteCount = 0;
            for (int num : nums) {
                if (num == 0) {
                    redCount++;
                } else if (num == 1) {
                    whiteCount++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int value = 2;
                if (redCount > 0) {
                    value = 0;
                    redCount--;
                } else if (whiteCount > 0) {
                    value = 1;
                    whiteCount--;
                }
                nums[i] = value;
            }
        }

    }
}
