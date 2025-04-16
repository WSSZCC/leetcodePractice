package test.leetcode2025;

import java.util.HashMap;

/**
 * 统计好子数组的数目
 */
public class CountGood {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int flag = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i],orDefault+1);
            if(map.get(nums[i])>1) {
                temp += map.get(nums[i])-1;
            }
            while (temp>=k){
                ans+=(n-i);
                Integer integer = map.get(nums[flag]);
                if(integer==1){
                    map.remove(nums[flag]);
                }else {
                    map.put(nums[flag],integer-1);
                    temp -=(integer-1);
                }
                flag++;
            }
        }
        return ans;
    }

}
