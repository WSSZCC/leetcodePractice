package test.leetcode2024;

import java.util.*;

/**
 * 查询数组中元素的出现位置
 */
public class OccurrencesOfElement {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans,-1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==x){
                list.add(i);
            }
        }
        int len = list.size();
        if(len==0){
            return ans;
        }
        for (int i = 0; i < queries.length; i++) {
            if(queries[i]<=len){
                ans[i] = list.get(queries[i]-1);
            }
        }
        return ans;
    }
}
