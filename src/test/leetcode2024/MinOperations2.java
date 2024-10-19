package test.leetcode2024;

/**
 * 使二进制数组全部等于 1 的最少操作次数 II
 */
public class MinOperations2 {
    public int minOperations(int[] nums) {
        int flag = 0;
        int count = 0;
        for (int num : nums) {
            if (num == flag) {
                flag = Math.abs(num - 1);
                count++;
            }
        }
        return count;
    }
}
