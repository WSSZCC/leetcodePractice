package test.leetcode2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 执行操作可获得的最大总奖励 II
 */
public class MaxTotalReward2 {
    public int maxTotalReward(int[] rewardValues) {
        int max = 0;
        for (int rewardValue : rewardValues) {
            max = Math.max(max,rewardValue);
        }
        Set<Integer> targetSet = new HashSet<>();
        for (int rewardValue : rewardValues) {
            if(targetSet.contains(max-1)){
                return 2*max-1;
            }
            if(targetSet.contains(rewardValue)){
                continue;
            }
            if(targetSet.contains(max-1-rewardValue)){
                return 2*max-1;
            }
            targetSet.add(rewardValue);
        }
        return getAns(max, targetSet);

    }

    private int getAns(int max, Set<Integer> targetSet) {
        Integer[] integers = targetSet.toArray(new Integer[0]);
        int[] ints = new int[max * 2];
        ints[0] =1;
        Arrays.sort(integers);
        for (Integer integer : integers) {
            for (int i = integer*2-1; i >=integer; i--) {
                if (ints[i - integer] == 1) {
                    ints[i] = 1;
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
