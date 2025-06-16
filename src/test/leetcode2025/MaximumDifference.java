package test.leetcode2025;

/**
 * 增量元素之间的最大差值
 */
public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int last = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            if(last>nums[i]){
                ans = Math.max(ans,last-nums[i]);
            }else {
                last = nums[i];
            }
        }
        return ans;

    }
}
