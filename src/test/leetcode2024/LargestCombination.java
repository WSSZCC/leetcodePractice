package test.leetcode2024;

import java.util.Arrays;

/**
 *  按位与结果大于零的最长组合
 */
public class LargestCombination {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        if(n==1){
            return n;
        }
        int maxCount = 0;
        Arrays.sort(candidates);
        while (candidates[n-1]!=0){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(candidates[i]==0){
                    continue;
                }
                if((candidates[i]&1)==1){
                    count++;
                }
                candidates[i] = candidates[i] >>= 1;
                System.out.println(candidates[i]);
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
