package test.leetcode2025;

/**
 * 2012. 数组美丽值求和
 */
public class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] preInts = new int[n];
        int[] suffInts = new int[n];
        preInts[0] = nums[0];
        suffInts[n-1] = nums[n-1];
        for (int i = 1; i < nums.length; i++) {
            preInts[i] = Math.max(preInts[i-1],nums[i]);
        }
        for (int i = n-2; i >=0; i--) {
            suffInts[i] = Math.min(suffInts[i+1],nums[i]);
        }
        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            if(preInts[i-1]<nums[i]&&suffInts[i+1]>nums[i]){
                ans+=2;
                continue;
            }
            if(nums[i-1]<nums[i]&&nums[i]<nums[i+1]){
                ans+=1;
            }
        }
        return ans;
    }
}
