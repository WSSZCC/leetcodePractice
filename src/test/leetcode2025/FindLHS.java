package test.leetcode2025;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最长和谐子序列
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num,orDefault+1);
        }
        int n = map.size();
        if(n==1){
            return 0;
        }
        Integer[] array = map.keySet().toArray(new Integer[0]);
        Arrays.sort(array);
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            if(array[i+1]-array[i]==1){
                ans = Math.max(ans,map.get(array[i+1])+map.get(array[i]));
            }
        }
        return ans;
    }
}
