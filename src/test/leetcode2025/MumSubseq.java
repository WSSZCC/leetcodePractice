package test.leetcode2025;

import java.util.Arrays;

/**
 * 满足条件的子序列数目
 */
public class MumSubseq {
    int MOD = 1000000007;
    int MAX = 100000;
    int[] ints = new int[MAX+1];
    boolean isTrue = false;

    public int numSubseq(int[] nums, int target) {
        build();
        isTrue = true;
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        long ans = 0;
        while (left<=right){
            if(nums[left]+nums[right]<=target){
                ans+=ints[right-left];
                ans%=MOD;
                left++;
            }else {
                right--;
            }
        }
        return (int)ans%MOD;
    }

    public void build(){
        if(isTrue){
            return;
        }
        Arrays.fill(ints,1);
        for (int i = 1; i <= MAX; i++) {
            ints[i]= ints[i-1]*2%MOD;
        }
    }
}
