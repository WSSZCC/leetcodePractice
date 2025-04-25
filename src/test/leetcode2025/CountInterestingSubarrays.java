package test.leetcode2025;

import java.util.List;

/**
 * 统计趣味子数组的数目
 */
public class CountInterestingSubarrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] ints = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ints[i+1] = ints[i];
            if(nums.get(i)%modulo==k){
                ints[i+1]++;
            }
        }
        long[] ints1 = new long[Math.min(n + 1, modulo)];
        long ans =0;
        for (int anInt : ints) {
            if(anInt>k){
                ans+=ints1[(anInt-k)%modulo];
            }
            ints1[anInt%modulo]++;
        }
        return ans;
    }
}
