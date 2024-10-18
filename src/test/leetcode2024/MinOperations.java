package test.leetcode2024;

/**
 * 使二进制数组全部等于 1 的最少操作次数 I
 */
public class MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            if(nums[i]==0){
                nums[i+1] = Math.abs(1-nums[i+1]);
                nums[i+2] = Math.abs(1-nums[i+2]);
                count++;
            }
        }
        if(nums[n-1]!=1||nums[n-2]!=1){
            count=-1;
        }
        return count;
    }
}
