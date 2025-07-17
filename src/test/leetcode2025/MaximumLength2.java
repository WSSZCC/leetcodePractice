package test.leetcode2025;

/**
 * 找出有效子序列的最大长度 II
 */
public class MaximumLength2 {
    public int maximumLength(int[] nums, int k) {
        int[][] ints = new int[k][k];
        int ans = 0;
        for (int num : nums) {
            int i = num % k;
            for (int j = 0; j < k; j++) {
                int value = (j - i + k) % k;
                ints[i][value] = ints[value][i]+1;
                ans = Math.max(ans,ints[i][value]);
            }
        }
        return ans;
    }
}
