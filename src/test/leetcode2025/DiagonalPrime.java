package test.leetcode2025;

/**
 * 对角线上的质数
 */
public class DiagonalPrime {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i][i]>ans&&isTrue(nums[i][i])){
                ans = nums[i][i];
            }
            if(nums[i][n-i-1]>ans&&isTrue(nums[i][n-i-1])){
                ans = nums[i][n-i-1];
            }
        }
        return ans;

    }

    private boolean isTrue(int n) {
        for (int i = 2; i*i <= n; i++) {
            if(n%i==0){
                return false;
            }
        }
        return n>1;
    }
}
