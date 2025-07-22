package test.leetcode2025;

import java.util.HashMap;

/**
 * 删除子数组的最大得分
 */
public class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int temp = 0;
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int  i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                ans = Math.max(temp,ans);
                for (int j = index; j < map.get(nums[i]); j++) {
                    temp-=nums[j];
                    map.remove(nums[j]);
                }
                index = map.get(nums[i])+1;
                map.put(nums[i],i);
                continue;
            }
            map.put(nums[i],i);
            temp+=nums[i];

        }
        return Math.max(ans,temp);
    }
}
