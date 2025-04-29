package test.leetcode2025;

/**
 * 统计最大元素出现至少 K 次的子数组
 */
public class CountSubarrays2962 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        int flag = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==max){
                k--;
            }
            while (k==0){
                if(nums[flag]==max){
                    k++;
                }
                ans+=n-i;
                flag++;
            }
        }
        return ans;
    }
}
