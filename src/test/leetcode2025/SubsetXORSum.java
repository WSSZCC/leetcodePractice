package test.leetcode2025;

/**
 *  找出所有子集的异或总和再求和
 */
public class SubsetXORSum {
    int ans;
    public int subsetXORSum(int[] nums) {
        ans = 0;
        int n = nums.length;
        backtrack(nums,n,0,0);
        return ans;
    }

    private void backtrack(int[] nums, int n, int i,int value) {
        if(i==n){
            return;
        }
        for (int j = i; j < n; j++) {
            value^=nums[j];
            ans+=value;
            backtrack(nums, n, j+1, value);
            value^=nums[j];
        }
    }
}
