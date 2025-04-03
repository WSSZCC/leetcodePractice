package test.leetcode2025;

import java.util.Arrays;

/**
 * 有序三元组中的最大值 II
 */
public class MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                if(nums[i]<nums[j]){
                    continue;
                }
                int value = nums[i]-nums[j];
                for (int k = j+1; k < n; k++) {
                    ans=Math.max(ans,value*nums[k]);
                }
            }
        }
        return ans;
    }

    public long maximumTripletValue1(int[] nums) {
        int n = nums.length;
        int[] pres = new int[n];
        int[] lasts = new int[n];
        Arrays.fill(pres,0);
        Arrays.fill(lasts,0);
        for (int i = 1; i < n; i++) {
            pres[i] = Math.max(pres[i-1],nums[i-1]);
            lasts[n-1-i] = Math.max(lasts[n-i],nums[n-1]);
        }
        long ans = 0;
        for (int i = 1; i < n-1; i++) {
            ans = Math.max(ans, (long) (pres[i] - nums[i]) *lasts[i]);
        }
        return ans;
    }
}
