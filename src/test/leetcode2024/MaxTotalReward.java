package test.leetcode2024;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 执行操作可获得的最大总奖励 I
 */
public class MaxTotalReward {
    public static void main(String[] args) {
        maxTotalReward(new int[]{1,1,3,3});
    }
    public static int maxTotalReward(int[] rewardValues) {
        int max = 0;
        for (int rewardValue : rewardValues) {
            max = Math.max(max,rewardValue);
        }
        HashSet<Integer> set = new HashSet<>();

        for (int rewardValue : rewardValues) {
            if(set.contains(max-1)){
                return 2*max -1;
            }
            if(set.contains(rewardValue)){
                continue;
            }
            if(set.contains(max-1-rewardValue)){
                return 2*max-1;
            }
            set.add(rewardValue);
        }
        Integer[] arrays = set.toArray(new Integer[0]);
        Arrays.sort(arrays);
        int[] ints = new int[max * 2];
        ints[0] = 1;
        for (Integer array : arrays) {
            for (int j = 2*array-1; j>=array; j--) {
                if(ints[j-array]==1){
                    ints[j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]==1){
                ans=i;
            }
        }
        return ans;
    }
}
