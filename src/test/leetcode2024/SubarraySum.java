package test.leetcode2024;

/**
 * 和为 K 的子数组
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            nums[j] = nums[j] + nums[j - 1];
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i]==k){
                count++;
            }
            for (int j = 0; j < i; j++) {
                if(nums[i]-nums[j]==k){
                    count++;
                }
            }
        }
        if(nums[0]==k){
            count++;
        }
        return count;
    }
}
