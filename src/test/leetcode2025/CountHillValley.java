package test.leetcode2025;

/**
 *  统计数组中峰和谷的数量
 */
public class CountHillValley {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int pre  = nums[0];
        for (int i = 1; i < n-1; i++) {
            if(nums[i]==pre||nums[i]==nums[i+1]){
                continue;
            }
            if((pre>nums[i]&&nums[i]<nums[i+1])||(pre<nums[i]&&nums[i]>nums[i+1])){
                ans++;
            }
            pre= nums[i];
        }
        return ans;
    }
}
