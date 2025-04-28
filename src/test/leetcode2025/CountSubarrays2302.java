package test.leetcode2025;

/**
 * 统计得分小于 K 的子数组数目
 */
public class CountSubarrays2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long temp = 0;
        int flag = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            temp+=nums[i];
            flag++;
            while (temp*(i-index+1)>=k){
                flag--;
                ans+=flag;
                temp-=nums[index];
                index++;
            }
        }
        for (int i = 0; i <= flag; i++) {
            ans+=i;
        }
        return ans;
    }
}
