package test.leetcode2025;

/**
 * 统计符合条件长度为 3 的子数组数目
 */
public class CountSubarrays3392 {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            if(2*(nums[i-1]+nums[i+1])==nums[i]){
                ans++;
            }
        }
        return ans;
    }
}
