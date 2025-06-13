package test.leetcode2025;

import java.util.Arrays;

/**
 * 最小化数对的最大差值
 */
public class MinimizeMax {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        if(p==0||n==1){
            return 0;
        }
        int right = nums[n-1]-nums[0];
        while (left<right){
            int mid = left+(right-left)/2;
            if(check(nums,p,mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int p, int mid) {
        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]-nums[i]<=mid){
                ans++;
                i+=1;
            }
        }
        return p<=ans;
    }
}
