package test.leetcode2025;

/**
 * 循环数组中相邻元素的最大差值
 */
public class MaxAdjacentDistance {
    public int maxAdjacentDistance(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i==n-1){
                ans = Math.max(ans,Math.abs(nums[i]-nums[0]));
            }else {
                ans = Math.max(ans,Math.abs(nums[i]-nums[i+1]));
            }
        }
        return ans;
    }
}
