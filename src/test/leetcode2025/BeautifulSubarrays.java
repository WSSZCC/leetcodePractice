package test.leetcode2025;

import java.util.HashMap;

/**
 * 统计美丽子数组数目
 */
public class BeautifulSubarrays {

    public static long beautifulSubarrays(int[] nums) {
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int flag =0;
        for (int num : nums) {
            flag^=num;
            Integer orDefault = map.getOrDefault(flag, 0);
            count+=orDefault;
            map.put(flag,orDefault+1);
        }
        return count;
    }
}
