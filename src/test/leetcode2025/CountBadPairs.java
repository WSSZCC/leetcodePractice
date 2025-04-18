package test.leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计坏数对的数目
 */
public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long ans = 0;
        while (n>0){
            n--;
            ans+=n;
        }
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i] - i, 0);
            map.put(nums[i]-i,orDefault+1);
        }
        for (Integer value : map.values()) {
                while (value>0){
                    value--;
                    ans-=value;
                }
        }
        return ans;
    }
}
