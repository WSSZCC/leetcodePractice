package test.leetcode2025;

import java.util.Arrays;

/**
 * 统计公平数对的数目
 */
public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = find(nums, lower - nums[i],i);
            int u = find(nums, upper - nums[i]+1,i);
            System.out.println(l);
            System.out.println(u);
            ans+=u-l;
        }
        return ans;
    }

    private int find(int[] nums, int value,int index) {
        int left = -1;
        int right = index;
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=value){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

}
