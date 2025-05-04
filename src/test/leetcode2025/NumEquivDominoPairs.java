package test.leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * 等价多米诺骨牌对的数量
 */
public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            String key = Math.max(dominoe[0], dominoe[1]) + "-" + Math.min(dominoe[0], dominoe[1]);
            Integer orDefault = map.getOrDefault(key, 0);
            map.put(key, orDefault + 1);
        }
        int ans = 0;
        for (Integer value : map.values()) {
            int v = value;
            while (v>=0){
                v--;
                ans+=v;
            }
        }
        return ans;
    }
}
