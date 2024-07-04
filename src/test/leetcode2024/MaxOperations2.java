package test.leetcode2024;

import java.util.Arrays;
import java.util.List;

/**
 * 相同分数的最大操作数目 II
 */
public class MaxOperations2 {

    public static void main(String[] args) {
        maxOperations(new int[]{2,2,1,2,1});
    }
    static int[][] ints;

    public static int maxOperations(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 1;
        }
        int maxCount = 0;
        ints = new int[n][n];
        maxCount = getMaxCount(n, maxCount, nums, 0, 1);
        maxCount = getMaxCount(n, maxCount, nums, n - 2, n - 1);
        maxCount = getMaxCount(n, maxCount, nums, 0, n - 1);
        return maxCount;
    }

    private static int getMaxCount(int n, int maxCount, int[] nums, int x, int x1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j]=-1;
            }
        }
        maxCount = Math.max(maxCount, dfs(0, n - 1, nums[x] + nums[x1], nums, 0));
        return maxCount;
    }

    public static int dfs(int l, int r, int sum, int[] nums, int ans) {
        if (l >= r) {
            return ans;
        }
        if(ints[l][r]>0){
            return ints[l][r];
        }
        if (nums[l] + nums[l + 1] == sum) {
            ans = Math.max(ans, 1 + dfs(l + 2, r, sum, nums, 0));
        }
        if (nums[r - 1] + nums[r] == sum) {
            ans = Math.max(ans, 1 + dfs(l, r - 2, sum, nums, 0));
        }
        if (nums[l] + nums[r] == sum) {
            ans = Math.max(ans, 1 + dfs(l + 1, r - 1, sum, nums, 0));
        }
        ints[l][r] = ans;
        return ans;
    }
}
